package model.mutter;

import java.util.ArrayList;
import model.user.User;

public class Mutter{
    private Integer id;
    private String name;
    private String text;

    public Mutter(Integer id,String name,String text){
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Mutter(String name,String text){
        // 上のコンストラクタを呼び出す。
        this(null,name,text);
    }

    //getter
    public String getName(){
        return this.name;
    }

    public String getText(){
        return this.text;
    }

    public Integer getId(){
        return this.id;
    }

    public void insert() {
        Repository.insert(this);
    }

    public static ArrayList<Mutter> indexMutters(User user){
        return Repository.indexMutters(user);
    }

    public static ArrayList<Mutter> indexMutters(){ 
        return Repository.indexMutters();
    }
    
    public void delete(){
        Repository.delete(this);
    }
    
}