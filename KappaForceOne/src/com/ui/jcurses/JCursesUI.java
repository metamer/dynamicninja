package com.ui.jcurses;

import com.all.CurrentGameMessage;
import com.all.GameMessage;
import com.all.util.Pair;
import com.frontend.GameMap;
import com.frontend.GameMapEntry;
import com.frontend.GameMapEntryColor;
import com.frontend.UIMenuType;
import com.frontend.UIState;
import com.frontend.UIStatus;
import com.frontend.UIStatusType;
import com.frontend.UserAction;
import com.frontend.UIMenu;
import com.ui.UI;
import com.ui.UIMenuTypeComparator;
import com.ui.UIStatusTypeComparator;

import jcurses.system.*;
import jcurses.widgets.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jcurses.custom.*;

public class JCursesUI extends Window implements UI {

    private CustomList messageList = null, currentMessageList= null, statusMessageList=null;
    private final int MESSAGE_LIMIT = 5;

    private java.util.List<CustomButton> menuList;
    private Map<CustomButton,UIMenuType> buttonToMenuTypeMap = new HashMap<CustomButton,UIMenuType>();
    CustomBorderPanel buttonPanel, gameMapPanel;
    //TextField inputField, tf_2, tf_3;
    private final static CharColor shortCutColor = new CharColor(CharColor.RED,CharColor.BLACK);
    private UIState uiState;
    private HashMap<Pair<Integer,Integer>,ModifiableLabel> coordLabelMap;
    private boolean uiInit;

    private static final Map<GameMapEntryColor, Short> COLOR_MAP = new HashMap<GameMapEntryColor,Short>(){/**
     * 
     */
        private static final long serialVersionUID = 1253189769108833435L;

        {
            put(GameMapEntryColor.BLUE, CharColor.BLUE);
            put(GameMapEntryColor.CYAN, CharColor.CYAN);
            put(GameMapEntryColor.GREEN, CharColor.GREEN);
            put(GameMapEntryColor.MAGENTA, CharColor.MAGENTA);
            put(GameMapEntryColor.RED, CharColor.RED);
            put(GameMapEntryColor.YELLOW, CharColor.YELLOW);
            put(GameMapEntryColor.WHITE, CharColor.WHITE);
            put(GameMapEntryColor.BLACK, CharColor.BLACK);
        }};

        public JCursesUI(int width, int height){
            super(width,height, true, "Game");

            uiInit = false;
            coordLabelMap = new HashMap<Pair<Integer,Integer>,ModifiableLabel> ();


            GridLayoutManager mainWindowManager = new GridLayoutManager(10,10);
            getRootPanel().setLayoutManager(mainWindowManager);

            buttonPanel = new CustomBorderPanel();
            messageList = new CustomList(MESSAGE_LIMIT);
            messageList.setTitle("Messages");

            currentMessageList = new CustomList(MESSAGE_LIMIT);
            currentMessageList.setTitle("Current Message");

            statusMessageList = new CustomList(MESSAGE_LIMIT);

            gameMapPanel = new CustomBorderPanel(80,20);

            //inputField = new TextField(5);

            mainWindowManager.addWidget(buttonPanel, 0,0,10,1, WidgetsConstants.ALIGNMENT_TOP, WidgetsConstants.ALIGNMENT_LEFT);
            mainWindowManager.addWidget(gameMapPanel, 0,1,5,9, WidgetsConstants.ALIGNMENT_CENTER, WidgetsConstants.ALIGNMENT_CENTER);
            mainWindowManager.addWidget(currentMessageList, 5,1,5,3, WidgetsConstants.ALIGNMENT_TOP, WidgetsConstants.ALIGNMENT_LEFT);
            mainWindowManager.addWidget(messageList, 5,4,5,3, WidgetsConstants.ALIGNMENT_TOP, WidgetsConstants.ALIGNMENT_LEFT);
            mainWindowManager.addWidget(statusMessageList, 5,7,5,3, WidgetsConstants.ALIGNMENT_TOP, WidgetsConstants.ALIGNMENT_LEFT);

            //mainWindowManager.addWidget(inputField, 5,9,5,1, WidgetsConstants.ALIGNMENT_TOP, WidgetsConstants.ALIGNMENT_LEFT);


            this.pack();
            this.show();

        }

        @Override
        public void drawUIState() {

            if(!uiInit){
                populateMenus();
                populateMessageList();
                populateCurrentMessage();
                populateStatusMessageList();
                populateGameMap();


                this.pack();
                this.repaint();

                uiInit = true;

            }else{
                updateMenus();
                updateMessageList();
                updateCurrentMessage();
                updateStatusMessageList();
                updateGameMap();
            }

        }

        public void updateMenus(){
            if(uiState.menuMapUpdated && repopulateMenus()){
                redrawMenus();
            }
        }

        public void updateMessageList(){
            if(uiState.gameMessagesUpdated && repopulateMessageList()){
                redrawMessageList();
            }
        }

        public void updateCurrentMessage(){
            if(uiState.currentGameMessageUpdated && repopulateCurrentMessage()){
                redrawCurrentMessage();
            }


        }

        public void updateStatusMessageList(){
            if(uiState.statusMessagesUpdated && repopulateStatusMessageList()){
                redrawStatusMessageList();
            }
        }

        public void updateGameMap(){
            if(uiState.gameMapUpdated && repopulateGameMap()){
                redrawGameMap();
            }
        }

        @Override
        public UserAction getUserAction() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void setUIState(UIState uiState) {
            this.uiState = uiState;

        }

        private boolean repopulateCurrentMessage(){
            populateCurrentMessage();
            return true;
        }

        private void redrawCurrentMessage(){
            currentMessageList.doRepaint();
        }

        private void populateCurrentMessage() {
            CurrentGameMessage currentGameMessage = uiState.getCurrentGameMessage();
            currentMessageList.clear();
            for(String s : currentGameMessage.getMessageText().split(String.format("%s",System.getProperty("line.separator")))){
                currentMessageList.add(s);
            }

            uiState.statusMessagesUpdated = false;
        }

        private boolean repopulateMenus(){
            populateMenus();
            return true;
        }

        private void redrawMenus(){
            buttonPanel.pack();
            buttonPanel.doPaint();
        }

        private void populateMenus(){
            Map<UIMenuType,UIMenu> menuMap = uiState.getMenuMap();
            menuList = new ArrayList<CustomButton>();

            buttonToMenuTypeMap = new HashMap<CustomButton,UIMenuType>();
            java.util.List<UIMenuType> availableMenuTypes = new ArrayList<UIMenuType>(menuMap.keySet());
            Collections.sort(availableMenuTypes, new UIMenuTypeComparator());
            for( UIMenuType umt : availableMenuTypes){
                UIMenu val = menuMap.get(umt);
                if(val != null){
                    CustomButton b = new CustomButton(val.getName());

                    if(val.getHotkey() != null){
                        b.setShortCut(val.getHotkey());
                        //b.setShortCutColors(shortCutColor);
                    }

                    buttonToMenuTypeMap.put(b,umt);
                    menuList.add(b);
                }
            }

            GridLayoutManager gm = new GridLayoutManager(menuList.size(),1);
            buttonPanel.setLayoutManager(gm);

            int i = 0;
            for(CustomButton b : menuList){
                if(b != null){
                    gm.addWidget(b, i, 0, 1, 1,WidgetsConstants.ALIGNMENT_TOP,WidgetsConstants.ALIGNMENT_LEFT);
                    i++;
                }
            }
            
            uiState.menuMapUpdated = false;
        }


        private void redrawMessageList(){
            messageList.doRepaint();      
        }

        private boolean repopulateMessageList(){
            populateMessageList();
            return true;
        }

        private void populateMessageList(){
            java.util.List<GameMessage> lgm = uiState.getGameMessages();
            messageList.clear();

            int addedMessages=0;
            for(int i = lgm.size() - 1; i >= 0 ; i--){
                if(lgm.get(i) != null){
                    messageList.add(lgm.get(i).getMessageText());
                    addedMessages++;
                }
                if(addedMessages >= MESSAGE_LIMIT){
                    break;
                }
            }
            uiState.gameMessagesUpdated = false;

        }

        private void redrawStatusMessageList(){
            statusMessageList.doRepaint();      
        }

        private boolean repopulateStatusMessageList(){
            populateStatusMessageList();
            return true;
        }

        private void populateStatusMessageList(){
            java.util.List<UIStatus> uis = uiState.getStatusMessages();
            statusMessageList.clear();

            HashMap<UIStatusType,StringBuilder> typeStringMap = new HashMap<UIStatusType,StringBuilder>();

            typeStringMap.put(UIStatusType.VITAL, new StringBuilder());
            typeStringMap.put(UIStatusType.STAT, new StringBuilder());
            typeStringMap.put(UIStatusType.EFFECT, new StringBuilder());

            for(int i = 0; i < uis.size() ; i++){
                if(uis.get(i) != null){
                    UIStatus st = uis.get(i);
                    typeStringMap.get(st.statusType).append('\t').append(st.toString());

                    
                }
            }
            
            ArrayList<UIStatusType> sortedKeys = new ArrayList<UIStatusType>();
            sortedKeys.addAll(typeStringMap.keySet());
            
            Collections.sort(sortedKeys,new UIStatusTypeComparator());
            
            for (UIStatusType uist : sortedKeys){
                statusMessageList.add(typeStringMap.get(uist).toString());
            }
            
            uiState.statusMessagesUpdated = false;
            
        }

        private void redrawGameMap(){
            for(ModifiableLabel ml : coordLabelMap.values()){
                ml.doRepaint(); //repaint one by one to prevent flickering
            }
        }

        private boolean repopulateGameMap(){

            GameMap gmap = uiState.getGameMap();

            int mapHeight = gmap.getHeight();
            int mapWidth = gmap.getWidth();

            for(int row = 0 ; row < mapHeight ; row++){
                for(int col = 0 ; col < mapWidth ; col++){
                    GameMapEntry gme = gmap.getObjectAt(row, col);

                    Pair<Integer,Integer> coord = new Pair<Integer,Integer>(row,col); 

                    ModifiableLabel targetLabel = coordLabelMap.get(coord);
                    if(targetLabel == null){
                        throw new IllegalStateException("Encountered unpopulated coordinate when updating game map");
                    }

                    targetLabel.setString(Character.toString(gme.getSymbol()));
                    targetLabel.setColors(new CharColor(COLOR_MAP.get(gme.getForegroundColor()),COLOR_MAP.get(gme.getBackgroundColor()))); 
                }
            }
            
            uiState.gameMapUpdated = false;

            return true;
        }

        private void populateGameMap(){

            GameMap gmap = uiState.getGameMap();

            int mapHeight = gmap.getHeight();
            int mapWidth = gmap.getWidth();
            DefaultLayoutManager gm = new DefaultLayoutManager();

            gameMapPanel.setLayoutManager(gm);

            for(int row = 0 ; row < mapHeight ; row++){
                for(int col = 0 ; col < mapWidth ; col++){
                    GameMapEntry gme = gmap.getObjectAt(row, col);

                    ModifiableLabel l = new ModifiableLabel(Character.toString(gme.getSymbol()),new CharColor(COLOR_MAP.get(gme.getForegroundColor()),COLOR_MAP.get(gme.getBackgroundColor())));

                    gm.addWidget(l, col, row, 1, 1, WidgetsConstants.ALIGNMENT_CENTER, WidgetsConstants.ALIGNMENT_CENTER);

                    Pair<Integer,Integer> p = new Pair<Integer, Integer>(row,col);
                    coordLabelMap.put(p, l);



                }
            }
            
            uiState.gameMapUpdated = false;
        }

}

