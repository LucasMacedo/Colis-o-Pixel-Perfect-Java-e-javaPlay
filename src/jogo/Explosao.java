
package jogo;

import java.awt.Graphics;
import javaPlay.GameObject;
import javaPlay.Sprite;

public class Explosao extends GameObject {

    protected Sprite sprite;
    private int frame;
    private int timeElapsedInMiliseconds;

    public Explosao(int x, int y){
        this.x = x;
        this.y = y;
        this.frame = 0;        
    }

    public void step(long timeElapsed) {
        if(this.frame >= 16){
            return; //Parou anima��o
        }

        this.timeElapsedInMiliseconds += timeElapsed;
        //Exemplo de anima��o baseada em tempo.
        //Muda de frame a cada 100 milisegundos.
        //A anima��o dura em torno de 1 segundos e 6
        if(this.timeElapsedInMiliseconds > 50){
            this.frame = (this.frame + 1);
            this.sprite.setCurrAnimFrame(this.frame);
            this.timeElapsedInMiliseconds -= 50;
        }
    }

    @Override
    public void draw(Graphics g) {
        this.sprite.draw(g, this.x, this.y);
    }

    public boolean isActive(){
        return (this.frame < 16);
    }



}
