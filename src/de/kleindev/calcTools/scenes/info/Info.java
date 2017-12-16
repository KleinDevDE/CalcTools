package de.kleindev.calcTools.scenes.info;

import de.kleindev.calcTools.tools.WebPage;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;

/**
 * CalcTools
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 2017, created by KleinDev
 */
public class Info {

    public ImageView gitHubImage;
    public Hyperlink hyperLink;

    public void onGitHubImageClick(){
        WebPage.openWebpage("https://github.com/KleinDevDE");
    }

    public void onHyperLinkClick(){
        WebPage.openWebpage("https://klein-max.de");
    }
}
