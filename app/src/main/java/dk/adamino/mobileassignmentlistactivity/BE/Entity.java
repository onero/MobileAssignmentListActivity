package dk.adamino.mobileassignmentlistactivity.BE;

import android.media.Image;

/**
 * Created by Adamino.
 */

public class Entity {
    public Image mImage;
    public String mName;

    public Entity(String name) {
        mName = name;
    }


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
