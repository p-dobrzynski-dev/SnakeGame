import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameEngine{

    private Board board;
    private GraphicsContext context;
    private AnimationTimer animator;
    private long lastRefreshTime;
    private boolean keyAvailable = true;

    public GameEngine(Board board, GraphicsContext context){
        this.board = board;
        this.context = context;
    }

    public void startGame(){
        lastRefreshTime = System.currentTimeMillis();
        AnimationTimer animator = new AnimationTimer(){
            @Override
            public void handle(long l) {
                long currentTime = System.currentTimeMillis();
                if ((currentTime-lastRefreshTime)>100){
                    board.paintBoard(context);
                    lastRefreshTime = System.currentTimeMillis();
                    keyAvailable = true;
                }
            }
        };
        animator.start();
    }

    public boolean isKeyAvailable(){
        return keyAvailable;
    }
    public void setKeyAvailable(boolean isAvailable){
        keyAvailable = isAvailable;
    }
}
