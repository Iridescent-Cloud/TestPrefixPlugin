package com.kimcodns.testprefixplugin.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerData {
    /*
    플레이어의 관리자 권한을 설정 및 확인합니다.(Manager 변수에 저장)
    플레이어의 칭호 목록을 관리합니다.
     */
    private static Map<Player, String> Manager = new HashMap<>();

    public static void setManager(Player player) {
        Manager.put(player, "Manager");
    }

    public static void deManager(Player player) {
        Manager.remove(player);
    }

    public static boolean isManager(Player player) {
        return Manager.getOrDefault(player, "").equals("Manager");
    }

    // ***************************************************************************

    private static Map<Player, ArrayList<String>> playerTitles = new HashMap<>();
    private static Map<Player, String> appliedPlayerTitles = new HashMap<>();

    public static void addPlayerTitle(Player player, String title) {
        playerTitles.computeIfAbsent(player, k -> new ArrayList<>()).add(title);
    }

    public static boolean hasPlayerTitle(Player player, String title) {
        return playerTitles.getOrDefault(player, new ArrayList<>()).contains(title);
    }

    public static boolean isTherePlayerRecord(Player player) {
        return playerTitles.containsKey(player);
    }

    public static ArrayList<String> getPlayerTitle(Player player) {
        return playerTitles.get(player);
    }

    public static void delPlayerTitle(Player player, String title) {
        ArrayList<String> a = playerTitles.get(player);
        if(a.contains(title)) {
            a.remove(title);
        }
    }

    public static void applyTitle(Player player, String title) {
        appliedPlayerTitles.put(player, title);
    }

    public static String getAppliedTitle(Player player) {
        return appliedPlayerTitles.getOrDefault(player, "");
    }

    public static void delAppliedTitle(Player player) {
        appliedPlayerTitles.remove(player);
    }
}
