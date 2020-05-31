package sulotion;
/*你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。

给定一个数字 n，找出可形成完整阶梯行的总行数。*/
public class arrangeCoins {
    public int arrangeCoins(int n){
        return (int)(Math.sqrt(2)*Math.sqrt(n+0.125)-0.5);
    }
}
