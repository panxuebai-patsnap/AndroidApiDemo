package cn.codedev.demo.apidemo;

/**
 * Created by panxb on 21/05/17.
 */

public class SpinnerData {
    private int code;
    private String value;

    public SpinnerData(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value == null ? "" : value;
    }
}
