package JavaLogicMethod;

/*
 * Datahouse class where all data are stored
 */
/**
 *
 * @author ZuoyunJin(16825)
 */
public class Datahouse {

    //initilize user id ,pw and quiz answer
    private String id, pw, quizAnswer1, quizAnswer2, quizAnswer3, quizAnswer4;
    private String webSite, regex;

    Datahouse() {
        this.id = "dorset";
        this.pw = "1234";
        this.quizAnswer1 = "1731";
        this.quizAnswer2 = "Italian";
        this.quizAnswer3 = "47";
        this.quizAnswer4 = "121m";
    }

    //websites are stored in switch case,each case will give different string value to webSite variable
    Datahouse(String webSite) {
        this.webSite = webSite;

        switch (webSite) {
            case "FB":
                this.webSite = "https://www.facebook.com/powerscourtestate/";

                break;
            case "TW":
                this.webSite = "https://twitter.com/hashtag/Powerscourt?src=hash";

                break;
            case "powerscourt":
                this.webSite = "https://powerscourt.com/";

                break;
            case "dublinBus":
                this.webSite = "http://www.dublinbus.ie/";

                break;
            case "irishRail":
                this.webSite = "http://www.irishrail.ie/";

                break;
            case "googleMap":
                this.webSite = "https://www.google.com/maps";

                break;
            case "INS":
                this.webSite = "https://www.instagram.com/powerscourt_estate/";

                break;
            default:
        }
    }

    //java regex are stored in switch case,each case will give different string value to regex variable
    Datahouse(int pageNumber,String regex) {
        this.regex = regex;

        switch (pageNumber) {
            case 9:
                switch (regex) {
            /*example of regex defin
            ^ = start of input
            () = multiple options to match
            First argument [1-9] - matches any entries between 1 and 9
            | = OR argument separator
            Second Argument [1-9][0-9] - matches entries between 10 and 99
            Last Argument 100 - Self explanatory - matches entries of 100
             */
                    case "numberOfPeoplePattern":
                     this.regex = "^([1-9]|([1-5][0-9]|6[0-5]))$";
                break;
                   case "timePattern":
                this.regex = "^((1[6-9]|2[0-1]):[0-5][0-9]|22:00)$";
                break;
                default:
                }
                break;
            case 10:
                switch (regex) {
                    case "datePattern":
                     this.regex = "^([0-9]{4}-([0][1-9]|[1][0-2])-([0-2][1-9]|[3][0-1]))$";
                break;
                default:
                }
                break;
            case 11:
                switch (regex) {
                    case "numberOfPeoplePattern":
                     this.regex =  "^([1-9]|[1-9][0-9]|100)$";
                break;
                   case "timePattern":
                this.regex = "^((9|1[0-5]):[0-5][0-9]|16:00)$";
                break;
                   case "datePattern":
                this.regex = "^(([0-2][1-9]|[3][0-1])/([0][1-9]|[1][0-2])/([0-9]){4})$";
                break;
                default:
                }
                break;
            default:
        }      
    }

    public String getWebSite() {
        return webSite;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getQuizAnswer1() {
        return quizAnswer1;
    }

    public String getQuizAnswer2() {
        return quizAnswer2;
    }

    public String getQuizAnswer3() {
        return quizAnswer3;
    }

    public String getQuizAnswer4() {
        return quizAnswer4;
    }

    public String getRegex() {
        return regex;
    }

}
