package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 1f;

    private Texture img;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 pos;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic1.jpg");
        touch = new Vector2();
        v = new Vector2();
        pos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.5f,0.9f, 0.4f,  1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if ((pos.y + img.getHeight()) < Gdx.graphics.getHeight()){
            pos.add(v);
        }
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(pos).setLength(V_LEN));
        System.out.println("touch.x = " + touch.x + " touch.y " + touch.y);
        return false;
    }
}
