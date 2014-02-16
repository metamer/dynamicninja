package com.frontend;

public class UIStatus {

    public String title, abbreviation, description;
    public UIStatusType statusType;
    
    public UIStatus(String title, String abbreviation, String description, UIStatusType statusType) {
        this.title = title;
        this.abbreviation=abbreviation;
        this.description=description;
        this.statusType = statusType;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        if(abbreviation != null){
            sb.append(abbreviation);
        }else if (title != null){
            sb.append(title);
        }
        
        return sb.toString();
    }
    

}
