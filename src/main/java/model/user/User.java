package model.user;



public class User {
    private Integer id;
    private String name;
    private String pass;

    public User(Integer id,String name,String pass){
        this.id = id;
        this.name = name;
        this.pass = pass;

    }
    //setメソッド
    public void setName(String name) {
        this.name = name;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    //getメソッド
    public String getName() {
        return name;
    }
    public String getPass() {
        return pass;
    }

    // 新規登録用メソッド
    public void signUpUser() {
        Repository.signUpUser(this);
    }

    // ログイン用メソッド
    public User login() {
        // emailをもとにユーザーが存在するかどうか調べる
        User cuurentUser = Repository.selectUserByName(this.name);
        //返されたユーザーのパスワードと入力されたパスワードが一致するか確認する。一致しなかったらcuurentUserをnullにする。
        if(cuurentUser != null){
            if(!cuurentUser.getPass().equals(this.pass)){
                cuurentUser = null;
            }
        }
        return cuurentUser;
    }
}