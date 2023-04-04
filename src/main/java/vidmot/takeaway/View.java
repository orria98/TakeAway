package vidmot.takeaway;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View
{
    SIGNUP("vidskiptavinur-view.fxml"),
    LOGIN("login-view.fxml"),
    MAIN("pontun-view.fxml"),
    GREIDSLA("greidsla-view.fxml");;


    private final String fileName;

    View(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName()
    {
        return fileName;
    }
}
