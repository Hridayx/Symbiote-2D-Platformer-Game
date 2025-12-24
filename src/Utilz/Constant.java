package Utilz;

public class Constant {
    public static class Directions {
        public static final int Left = 0;
        public static final int Up = 1;
        public static final int Right = 2;
        public static final int Down = 3;
    }
    
    public static class PlayerConstants {
        public static final int Attack_1 = 0;
        public static final int Attack_2 = 1;
        public static final int Attack_3 = 2;
        public static final int Dead = 3;
        public static final int Idle = 4;
        public static final int Jump = 5;
        public static final int Run = 6;
        public static final int Walk = 7;

        public static int GetSpriteAmount(int playerAction) {
            switch (playerAction) {
                case Jump:
                    return 13;
                case Walk:
                case Idle:
                    return 8;
                case Run:
                    return 7;
                case Attack_3:
                    return 5;	
                case Attack_1:
                case Attack_2:
                    return 4;
                case Dead:
                    return 3;
                default:
                    return 1;
            }
        }
    }
}
