package domain;

import java.util.*;

public class Game implements Subject{
    private Map<Integer, Player> players;
    private Map<Player, List<Turn>> turns;
    private Map<EventType, List<Observer>> observers;
    private Dice dice;
    private List<Integer> dices;
    private Queue<Player> playerQueue = new LinkedList<>();
    private List<Turn> listOfTurns;
    private Player currentPlayer;
    private int turnNumber;
    private int previousScore;

    public Game() {
        players = new HashMap<>();
        turns = new HashMap<>();
        observers = new HashMap<>();
        dice = new Dice();
        turnNumber = 1;
        listOfTurns = new ArrayList<>();
    }

    public void addPlayer(Player p) {
        players.put(p.getPlayerId(), p);
        turns.put(p, new ArrayList<Turn>());
        playerQueue.add(p);
    }

    public Map<Integer, Player> getPlayers() {
        return players;
    }

    @Override
    public void addObserver(EventType e, Observer o) {
        if (observers.get(e) == null){
            List<Observer> observers = new ArrayList<>();
            observers.add(o);
            this.observers.put(e,observers);
        }else{
            List<Observer> observers = this.observers.get(e);
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(EventType e, Observer o) {
        this.observers.get(e).remove(o);
    }

    @Override
    public void notifyObserver(EventType e, String s) {
        for (Observer o:this.observers.get(e)) {
            o.update(s);
        }
    }

    public void step(int playerId) {
        currentPlayer = playerQueue.poll();
        if (currentPlayer == null){
            throw new IllegalStateException("something went wrong");
        }
        if (turns.get(currentPlayer).size() < 4){
            int d1 = dice.throwDice();
            int d2 = dice.throwDice();
            Turn t = new Turn(currentPlayer,d1,d2,previousScore);
            turns.get(currentPlayer).add(t);
            previousScore = d1+d2;
            playerQueue.add(currentPlayer);
            Player p2 = playerQueue.peek();
            p2.setCurrent(true);
            setTurn();
            notifyObserver(EventType.PLAYERVIEW, t.toString());
        }else{
            endGame();
        }
    }

    private String getScoreViewString() {
        String result ="";
        for (Map.Entry<Player,List<Turn>> entry:this.turns.entrySet()) {
            int sum =0;
            for (Turn t:entry.getValue()) {
                sum += t.getScore();
            }
            result += entry.getKey().getName() + " " + sum + " ";
        }
        return result;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void setTurn() {
        Integer max = Integer.MAX_VALUE;
        for (Map.Entry<Player,List<Turn>> entry :this.turns.entrySet()) {
            if (max>entry.getValue().size()){
                max = entry.getValue().size();
            }
        }
        if (this.turnNumber != max+1){
            notifyObserver(EventType.SCOREVIEW,getScoreViewString());
        }
        this.turnNumber = max+1;
        if (this.turnNumber == 5){
            endGame();
        }
    }

    public void endGame() {
        notifyObserver(EventType.SCOREVIEW,"Game over "  + getWinningPlayer());
    }

    private String getWinningPlayer() {
        int max = 0;
        int som;
        Player p = null;
        for (Map.Entry<Player,List<Turn>> entry:this.turns.entrySet()) {
            som = 0;
            for (Turn t:entry.getValue()) {
                som+=t.getScore();
            }
            if (max<som){
                p = entry.getKey();
                max = som;
            }
        }
        return "the winner is " + p.toString() + " with a score of " + max;
    }
}