package gui;

public enum StandardText {
    NO_USER ("<html><p style='color:red'>NO USER LOGGED IN</p></html>");

    private String text;

    private StandardText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
