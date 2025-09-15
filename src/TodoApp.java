import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    showTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 0:
                    System.out.println("アプリを終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。もう一度入力してください。");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== ToDo管理アプリ ===");
        System.out.println("1. タスクを追加");
        System.out.println("2. タスク一覧を表示");
        System.out.println("3. タスクを削除");
        System.out.println("0. 終了");
        System.out.print("選択してください: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // 無効入力
        }
    }

    private static void addTask() {
        System.out.print("追加するタスクを入力してください: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("タスクを追加しました: " + task);
    }

    private static void showTask() {
        if (tasks.isEmpty()) {
            System.out.println("タスクはありません。");
        } else {
            System.out.println("\n=== タスク一覧 ===");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        showTask();
        if (tasks.isEmpty()) {
            return;
        }

        System.out.print("削除するタスク番号を入力してください: ");
        try {
            int index =Integer.parseInt(scanner.nextLine()) -1;
            if (index >= 0 && index < tasks.size()) {
                String removed = tasks.remove(index);
                System.out.println("削除しました: " + removed);
            } else {
                System.out.println("無効な番号です。");
            }
        } catch (NumberFormatException e) {
            System.out.println("数字を入力してください。");
        }
    }
}
