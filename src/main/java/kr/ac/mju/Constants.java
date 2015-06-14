package kr.ac.mju;

public class Constants {
    public enum LoginMsg {
        ID("존재하지 않는 아이디 입니다."),
        PASSWORD("비밀번호가 틀렸습니다."),
        SUCCESS("로그인에 성공했습니다.");
        private String msg;
        private LoginMsg(String msg) {
            this.msg = msg;
        }
        public String getMsg() {return this.msg;}
    }
    public enum DBMS {
        ID("sogong2015"),
        PASSWORD("mju12345"),
        URL("jdbc:mysql://localhost:3306/sogongDB");
        private String msg;
        private DBMS(String msg) {
            this.msg = msg;
        }
        public String getMsg() {return this.msg;}
    }
    
    public enum CreateMsg {
        LECTURE("강좌가 개설되었습니다.");
        private String msg;
        private CreateMsg(String msg) {
            this.msg = msg;
        }
        public String getMsg() {return this.msg;}
    }
    
    public enum ScoreMsg {
        Success("성적 입력에 성공했습니다."),
        Fail("성적 입력에 실패했습니다."),
        WRONG("강좌 번호가 틀렸습니다.");
        private String msg;
        private ScoreMsg(String msg) {
            this.msg = msg;
        }
        public String getMsg() {return this.msg;}
    }
    
    
    public enum RegisterMsg {
        LECTUREREGISTER("수강신청이 완료됐습니다."),
        FAILREGISTER("이미 수강신청된 과목입니다."),
        MAXOVER("정원 초과되었습니다."),
        USEREGISTER("회원 가입 되었습니다.");
        private String msg;
        private RegisterMsg(String msg) {
            this.msg = msg;
        }
        public String getMsg() {return this.msg;}
    }
}