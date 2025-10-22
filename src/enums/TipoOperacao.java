package enums;

public enum TipoOperacao {

    WRITE_TXT(1, "write Txt"),
    WRITE_CSV(2, "write Csv"),
    WRITE_FIX_TEXT(3, "write Fixed TXT"),
    WRITE_BIN(4, "Serialize"),
    COPY_FILE(5, "copy File"),
    SPECIAL_FEATURE(6, "Access Repository"),
    EXIT(7, "exit");


    private int cod;
    private String desc;

    TipoOperacao(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public int getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static TipoOperacao MatchOperations(int code){

        for (TipoOperacao value : TipoOperacao.values()) {
            if (value.getCod() == code) {
                return value;
            }
        }
        return null;
    }
}

