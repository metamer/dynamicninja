package com.frontend;

public class UIStatus {

    public String title, abbreviation, description;
    
    public UIStatus(String title, String abbreviation, String description) {
        this.title = title;
        this.abbreviation=abbreviation;
        this.description=description;
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
