package de.noneatme.mexteel;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;
import com.jme3.util.SkyFactory;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
        
    }

    @Override
    public void simpleInitApp() 
    {
        this.addMainElements();
        flyCam.setMoveSpeed(50.0f);
    }
    private Spatial createSky()
    {
        Texture up = assetManager.loadTexture("Textures/Sky/Maps/Map1/up.dds");
        Texture down = assetManager.loadTexture("Textures/Sky/Maps/Map1/down.dds");
        Texture west = assetManager.loadTexture("Textures/Sky/Maps/Map1/west.dds");
        Texture east = assetManager.loadTexture("Textures/Sky/Maps/Map1/east.dds");
        Texture north = assetManager.loadTexture("Textures/Sky/Maps/Map1/north.dds");
        Texture south = assetManager.loadTexture("Textures/Sky/Maps/Map1/south.dds");


        return SkyFactory.createSky(assetManager, west, east, north, south, up, down, Vector3f.UNIT_XYZ);
    }
    private boolean addMainElements()
    {
        // Scene
        Spatial scene           = assetManager.loadModel("Scenes/map1.j3o");
        DirectionalLight sun    = new DirectionalLight();
        Spatial sky             = this.createSky();//SkyFactory.createSky(assetManager, "Textures/Sky/Bright/cubemap.dds", true);
       
        /*
        sky.setCullHint(Spatial.CullHint.Never);
        sky.setQueueBucket(Bucket.Sky);
        sky.rotate(-90, 0, 0);
          */
        
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        scene.setLocalTranslation(0, 0, -2.0f);
        
        rootNode.addLight(sun);
        rootNode.attachChild(scene);   
        rootNode.attachChild(sky);
        
        return true;
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
