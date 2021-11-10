//Jose Ardila partner Pranav Akkaraju

//Period 2 Tully


import java.util.ArrayList;

import java.util.Random;


public class The_King_Is_Back implements PlayerInt {

    private char letter;

    private char opponentLetter;

    private String name;


    // Pre:       receives a char letter

    // Post:   sets the name to "Random AI" and the letter to the letter received

    The_King_Is_Back(char letter) {

        name = "The King Is Back";

        this.letter = letter;

    }


    public char getLetter() {

        return letter;

    }



    // Pre:       method is called

    // Post:   returns the Location where the player wants to move

    public Location getMove(Board board) {

        int max = -1;

        Location best = null;

        //Location best = new Location((int)(Math.random()*2+1), (int)(Math.random()*2+1), (int)(Math.random()*2+1));

        int emptyCounter=0;

        for(int i=0;i<4;i++)

        {

            for(int j=0;j<4;j++)

            {

                for(int k=0;k<4;k++)

                {

                    Location loc = new Location(k, j, i);

                    if(board.isEmpty(loc))

                    {

                        emptyCounter++;

                    }

                }

            }

        }

        if(emptyCounter>=64)

        {

            best = new Location((int)(Math.random()*2+1), (int)(Math.random()*2+1), (int)(Math.random()*2+1));

        }


        else if(emptyCounter>=63)

        {

            Location check = new Location(1,1,1);

            Location check2 = new Location(1,2,1);

            Location check3 = new Location(1,1,2);

            Location check4 = new Location(2,1,1);

            Location check5 = new Location(2,1,2);

            Location check6 = new Location(2,2,1);

            Location check7 = new Location(2,2,2);

            Location check8 = new Location(1,2,2);

            Location check9 = new Location(1,2,2);

            Location check10 = new Location(1,2,2);

            Location check11 = new Location(1,2,2);

            Location check12 = new Location(1,2,2);

            CountsTKIB counts = new CountsTKIB(board, check, letter);

            CountsTKIB counts2 = new CountsTKIB(board, check2, letter);

            CountsTKIB counts3 = new CountsTKIB(board, check3, letter);

            CountsTKIB counts4 = new CountsTKIB(board, check4, letter);

            CountsTKIB counts5 = new CountsTKIB(board, check5, letter);

            CountsTKIB counts6 = new CountsTKIB(board, check6, letter);

            CountsTKIB counts7 = new CountsTKIB(board, check7, letter);

            CountsTKIB counts8 = new CountsTKIB(board, check8, letter);

            CountsTKIB counts9 = new CountsTKIB(board, check9, letter);

            CountsTKIB counts10 = new CountsTKIB(board, check10, letter);

            CountsTKIB counts11 = new CountsTKIB(board, check11, letter);

            CountsTKIB counts12 = new CountsTKIB(board, check12, letter);

            int oppScore1 = counts.getOpp1s() * 1 + counts.getOpp2s() * 50 + counts.getOpp3s() * 200 + counts.getOpp4s() * 5000;

            int oppScore2 = counts2.getOpp1s() * 1 + counts2.getOpp2s() * 50 + counts2.getOpp3s() * 200 + counts2.getOpp4s() * 5000;

            int oppScore3 = counts3.getOpp1s() * 1 + counts3.getOpp2s() * 50 + counts3.getOpp3s() * 200 + counts3.getOpp4s() * 5000;

            int oppScore4 = counts4.getOpp1s() * 1 + counts4.getOpp2s() * 50 + counts4.getOpp3s() * 200 + counts4.getOpp4s() * 5000;

            int oppScore5 = counts5.getOpp1s() * 1 + counts5.getOpp2s() * 50 + counts5.getOpp3s() * 200 + counts5.getOpp4s() * 5000;

            int oppScore6 = counts6.getOpp1s() * 1 + counts6.getOpp2s() * 50 + counts6.getOpp3s() * 200 + counts6.getOpp4s() * 5000;

            int oppScore7 = counts7.getOpp1s() * 1 + counts7.getOpp2s() * 50 + counts7.getOpp3s() * 200 + counts7.getOpp4s() * 5000;

            int oppScore8 = counts8.getOpp1s() * 1 + counts8.getOpp2s() * 50 + counts8.getOpp3s() * 200 + counts8.getOpp4s() * 5000;

            int oppScore9 = counts9.getOpp1s() * 1 + counts9.getOpp2s() * 50 + counts9.getOpp3s() * 200 + counts9.getOpp4s() * 5000;

            int oppScore10 = counts10.getOpp1s() * 1 + counts10.getOpp2s() * 50 + counts10.getOpp3s() * 200 + counts10.getOpp4s() * 5000;

            int oppScore11 = counts11.getOpp1s() * 1 + counts11.getOpp2s() * 50 + counts11.getOpp3s() * 200 + counts11.getOpp4s() * 5000;

            int oppScore12 = counts12.getOpp1s() * 1 + counts12.getOpp2s() * 50 + counts12.getOpp3s() * 200 + counts12.getOpp4s() * 5000;


            int max1 = -1;

            if (oppScore1 > max1 && board.isEmpty(check)) {

                max1 = oppScore1;

                best = check;

            }

            if (oppScore2 > max1 && board.isEmpty(check2)) {

                max1 = oppScore2;

                best = check2;

            }

            if (oppScore3 > max1 && board.isEmpty(check3)) {

                max1 = oppScore3;

                best = check3;

            }

            if (oppScore4 > max1 && board.isEmpty(check4)) {

                max1 = oppScore4;

                best = check4;

            }

            if (oppScore5 > max1 && board.isEmpty(check5)) {

                max1 = oppScore5;

                best = check5;

            }

            if (oppScore6 > max1 && board.isEmpty(check6)) {

                max1 = oppScore6;

                best = check6;

            }

            if (oppScore7 > max1 && board.isEmpty(check7)) {

                max1 = oppScore7;

                best = check7;

            }

            if (oppScore8 > max1 && board.isEmpty(check8)) {

                max1 = oppScore8;

                best = check8;

            }

            if (oppScore9 > max1 && board.isEmpty(check9)) {

                max1 = oppScore9;

                best = check9;

            }


            if (oppScore10 > max1 && board.isEmpty(check10)) {

                max1 = oppScore10;

                best = check10;

            }

            if (oppScore11 > max1 && board.isEmpty(check11)) {

                max1 = oppScore11;

                best = check11;

            }

            if (oppScore12 > max1 && board.isEmpty(check12)) {

                max1 = oppScore12;

                best = check12;

            }

        }


        else {

            for (int s = 0; s < 4; s++) {

                for (int r = 0; r < 4; r++) {

                    for (int c = 0; c < 4; c++) {

                        Location loc = new Location(c, r, s);

                        if (board.isEmpty(loc)) {

                            CountsTKIB counts = new CountsTKIB(board, loc, letter);

                            int score = counts.getMy1s() * 2 + counts.getMy2s() * 35 + counts.getMy3s() * 400 + counts.getMy4s() * 10000;

                            int oppScore = counts.getOpp1s() * 1 + counts.getOpp2s() * 20 + counts.getOpp3s() * 250 + counts.getOpp4s() * 7000;

                            if (score >= max) {

                                max = score;

                                best = loc;

                            }

                            if (oppScore > max) {

                                max = oppScore;

                                best = loc;

                            }

                        }

                    }

                }

            }

        }

        return best;

    }


    @Override

    public String getName () {

        return name;

    }


    @Override

    public PlayerInt freshCopy () {

        return new The_King_Is_Back(letter);

    }


    class CountsTKIB {

        private int my4s, my3s, my2s, my1s, opp4s, opp3s, opp2s, opp1s;

        private Board board;

        private Location l;

        private char me, opp;


        public CountsTKIB(Board board, Location l, char me) {

            my1s = 0;

            my2s = 0;

            my3s = 0;

            my4s = 0;

            opp1s = 0;

            opp2s = 0;

            opp3s = 0;

            opp4s = 0;

            this.board = board;

            this.l = l;

            this.me = me;

            opp = (me =='X')?'O':'X';

            calculate();

        }


        public void calculate() {

            int c = l.getCol();

            int r = l.getRow();

            int s = l.getSheet();

            char[][][] b = board.getData();

            //horizontal

            int count = 1;

            for (int x = 0; x < board.numCols(); x++) {

                if (b[s][r][x] == me) {

                    count++;

                } else if (b[s][r][x] == opp) {

                    count = 0;

                    break;

                }

            }

            addMe(count);

            //opponent horizontal

            count = 1;

            for (int x = 0; x < board.numCols(); x++) {

                if (b[s][r][x] == opp) {

                    count++;

                } else if (b[s][r][x] == me) {

                    count = 0;

                    break;

                }

            }

            addOpponent(count);

            //vertical

            count = 1;

            for (int rr = 0; rr < board.numCols(); rr++) {

                if (b[s][rr][c] == me) {

                    count++;

                } else if (b[s][rr][c] == opp) {

                    count = 0;

                    break;

                }

            }

            addMe(count);

            //opponent vertical

            count = 1;

            for (int rr = 0; rr < board.numCols(); rr++) {

                if (b[s][rr][c] == opp) {

                    count++;

                } else if (b[s][rr][c] == me) {

                    count = 0;

                    break;

                }

            }

            addOpponent(count);

            //backwards

            count = 1;

            for (int ss = 0; ss < board.numCols(); ss++) {

                if (b[ss][r][c] == me) {

                    count++;

                } else if (b[ss][r][c] == opp) {

                    count = 0;

                    break;

                }

            }

            addMe(count);

            //opponent backwards

            count = 1;

            for (int ss = 0; ss < board.numCols(); ss++) {

                if (b[ss][r][c] == opp) {

                    count++;

                } else if (b[ss][r][c] == me) {

                    count = 0;

                    break;

                }

            }

            addOpponent(count);

            //z sheet diagonal

            if (c == r) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    if (b[s][aa][aa] == me) {

                        count++;

                    } else if (b[s][aa][aa] == opp) {

                        count = 0;

                        break;

                    }

                }

                addMe(count);

            }

            //opponent z diagonal sheet

            if (c == r) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    if (b[s][aa][aa] == opp) {

                        count++;

                    } else if (b[s][aa][aa] == me) {

                        count = 0;

                        break;

                    }

                }

                addOpponent(count);

            }

            //z diagonal 2

            if (c + r == 3) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[s][aa][3 - aa] == me) {

                        count++;

                    } else if (b[s][aa][3 - aa] == opp) {

                        count = 0;

                        break;

                    }

                }

                addMe(count);

            }

            // opp z diag 2

            if (c + r == 3) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[s][aa][3 - aa] == opp) {

                        count++;

                    } else if (b[s][aa][3 - aa] == me) {

                        count = 0;

                        break;

                    }

                }

                addOpponent(count);

            }

            //y plane d1

            if (c == s) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][r][aa] == me) {

                        count++;

                    } else if (b[aa][r][aa] == opp) {

                        count = 0;

                        break;

                    }

                }

                addMe(count);

            }

            //opp y plane d1

            if (c == s) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][r][aa] == opp) {

                        count++;

                    } else if (b[aa][r][aa] == me) {

                        count = 0;

                        break;

                    }

                }

                addOpponent(count);

            }

            //y plane d2

            if (c + s == 3) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][r][3 - aa] == me) {

                        count++;

                    } else if (b[aa][r][3 - aa] == opp) {

                        count = 0;

                        break;

                    }

                }

                addMe(count);

            }

            //opp y plane d2

            if (c + s == 3) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][r][3 - aa] == opp) {

                        count++;

                    } else if (b[aa][r][3 - aa] == me) {

                        count = 0;

                        break;

                    }

                }

                addOpponent(count);

            }

            //x plane d1

            if (r == s) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][aa][c] == me) {

                        count++;

                    } else if (b[aa][aa][c] == opp) {

                        count = 0;

                        break;

                    }

                }

                addMe(count);

            }

            //opp x plane d1

            if (r == s) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][aa][c] == opp) {

                        count++;

                    } else if (b[aa][aa][c] == me) {

                        count = 0;

                        break;

                    }

                }

                addOpponent(count);

            }

            //x plane d2

            if (r + s == 3) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][3 - aa][c] == me) {

                        count++;

                    } else if (b[aa][3 - aa][c] == opp) {

                        count = 0;

                        break;

                    }

                }

                addMe(count);

            }

            // opp x plane d2

            if (r + s == 3) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][3 - aa][c] == opp) {

                        count++;

                    } else if (b[aa][3 - aa][c] == me) {

                        count = 0;

                        break;

                    }

                }

                addOpponent(count);

            }

            //special 1

            if ((c == 0 && r == 0 && s == 0) || (c == 1 && r == 1 && s == 1) || (c == 2 && r == 2 && s == 2) || (c == 3 && r == 3 && s == 3)) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][aa][aa] == me) {

                        count++;

                    } else if (b[aa][aa][aa] == opp) {

                        count = 0;

                        break;

                    }

                }

                addMe(count);


                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][aa][aa] == opp) {

                        count++;

                    } else if (b[aa][aa][aa] == me) {

                        count = 0;

                        break;

                    }

                }

                addOpponent(count);

            }


            //special 2

            if ((c == 3 && r == 0 && s == 0) || (c == 2 && r == 1 && s == 1) || (c == 1 && r == 2 && s == 2) || (c == 0 && r == 3 && s == 3)) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][aa][3-aa] == me) {

                        count++;

                    } else if (b[aa][aa][3-aa] == opp) {

                        count = 0;

                        break;

                    }

                }

                addMe(count);


                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[aa][aa][3-aa] == opp) {

                        count++;

                    } else if (b[aa][aa][3-aa] == me) {

                        count = 0;

                        break;

                    }

                }

                addOpponent(count);

            }


            //special 3

            if ((c == 0 && r == 0 && s == 3) || (c == 1 && r == 1 && s == 2) || (c == 2 && r == 2 && s == 1) || (c == 3 && r == 3 && s == 0)) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[3-aa][aa][aa] == me) {

                        count++;

                    } else if (b[3-aa][aa][aa] == opp) {

                        count = 0;

                        break;

                    }

                }

                addMe(count);


                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[3-aa][aa][aa] == opp) {

                        count++;

                    } else if (b[3-aa][aa][aa] == me) {

                        count = 0;

                        break;

                    }

                }

                addOpponent(count);

            }


            //special 4

            if ((c == 3 && r == 0 && s == 3) || (c == 2 && r == 1 && s == 2) || (c == 1 && r == 2 && s == 1) || (c == 0 && r == 3 && s == 0)) {

                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[3-aa][aa][3-aa] == me) {

                        count++;

                    } else if (b[3-aa][aa][3-aa] == opp) {

                        count = 0;

                        break;

                    }

                }

                addMe(count);


                count = 1;

                for (int aa = 0; aa < 4; aa++) {

                    //if (b[z][aa][3-aa])

                    if (b[3-aa][aa][3-aa] == opp) {

                        count++;

                    } else if (b[3-aa][aa][3-aa] == me) {

                        count = 0;

                        break;

                    }

                }

                addOpponent(count);

            }

        }


        public void addMe(int c) {

            if (c == 1) {

                my1s++;

            } else if (c == 2) {

                my2s++;

            } else if (c == 3) {

                my3s++;

            } else if (c == 4) {

                my4s++;

            }

        }


        public void addOpponent(int c) {

            if (c == 1) {

                opp1s++;

            } else if (c == 2) {

                opp2s++;

            } else if (c == 3) {

                opp3s++;

            } else if (c == 4) {

                opp4s++;

            }

        }


        public int getMy4s() {

            return my4s;

        }


        public void setMy4s(int my4s) {

            this.my4s = my4s;

        }


        public int getMy3s() {

            return my3s;

        }


        public void setMy3s(int my3s) {

            this.my3s = my3s;

        }


        public int getMy2s() {

            return my2s;

        }


        public void setMy2s(int my2s) {

            this.my2s = my2s;

        }


        public int getMy1s() {

            return my1s;

        }


        public void setMy1s(int my1s) {

            this.my1s = my1s;

        }


        public int getOpp4s() {

            return opp4s;

        }


        public void setOpp4s(int opp4s) {

            this.opp4s = opp4s;

        }


        public int getOpp3s() {

            return opp3s;

        }


        public void setOpp3s(int opp3s) {

            this.opp3s = opp3s;

        }


        public int getOpp2s() {

            return opp2s;

        }


        public void setOpp2s(int opp2s) {

            this.opp2s = opp2s;

        }


        public int getOpp1s() {

            return opp1s;

        }


        public void setOpp1s(int opp1s) {

            this.opp1s = opp1s;

        }

    }

    

}









