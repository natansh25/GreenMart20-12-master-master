package infinity1087.android.com.examplehr.model;

public class MainButtonImage {

    String groupIcon, groupImage, groupBannerImage;


    public MainButtonImage(String groupIcon, String groupImage, String groupBannerImage) {
        this.groupIcon = groupIcon;
        this.groupImage = groupImage;
        this.groupBannerImage = groupBannerImage;
    }


    public String getGroupIcon() {
        return groupIcon;
    }

    public void setGroupIcon(String groupIcon) {
        this.groupIcon = groupIcon;
    }

    public String getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(String groupImage) {
        this.groupImage = groupImage;
    }

    public String getGroupBannerImage() {
        return groupBannerImage;
    }

    public void setGroupBannerImage(String groupBannerImage) {
        this.groupBannerImage = groupBannerImage;
    }
}
