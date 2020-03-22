package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String[]> dictionary = new HashMap<>();
        Map<String, String[]> newWords = new HashMap<>();

        dictionary.put("Глупый", new String[]{"Немой", "Плохой", "НЕнормальный", "Сумасшедший","Тупенький"});
        dictionary.put("Животное", new String[]{"Существо", "Млекопитающий", "Дикарь", "Зверек"});
        dictionary.put("Дом ", new String[]{"жилище", "помещение", "логово", "кров"});
        dictionary.put("Тратить", new String[]{"Одолжит", "Продать", "Дават в взаимы"});
        dictionary.put("Думать", new String[]{"Мыслить", "Задумыватся", "предпологать", "ощущать"});
        dictionary.put("Компьютер", new String[]{"Ноутбук", "Телефон", "Гаджет", "Планшет"});
        dictionary.put("Обычная Вода", new String[]{"Холодная вода", "Теплая вода", "Заморожонная вода", "Кипящая вода"});
        dictionary.put("Летать", new String[]{" Прыгать", " Скакать", "Бегать", "Двигаться"});


        Set<String> keys = dictionary.keySet();
        Iterator iterator = keys.iterator();
        while(iterator.hasNext()){
            String key = iterator.next().toString();
            String[] values = dictionary.get(key);
            newWords.put(key, values);
            for (int i = 0; i <values.length ; i++) {

                String StillKeys = values[i];
                ArrayList<String> common = new ArrayList<>(values.length);
                common.addAll(Arrays.asList(values));
                common.remove(StillKeys);
                common .add(key);
                String[] StillValues = new String[common.size()];
                StillValues =common .toArray(StillValues);
                System.out.println(StillKeys + " - " + Arrays.toString(StillValues));
                newWords.put(StillKeys, StillValues);
            }
        }

        for (Map.Entry<String,String[]>item:newWords.entrySet()
             ){
            System.out.println(" "+item.getKey()+" "+Arrays.toString((item.getValue())));
        } {

        }




        boolean i=true;
        while (i) {
            System.out.println("Введите слово: ");
            Scanner scanner = new Scanner(System.in);
            String sentences = scanner.nextLine();
            String[] words = sentences.split(" ");
            for (String word : words) {
                String[] synonyms = dictionary.get(word);
                String[] Synonyms1 = newWords.get(word);
                Random r = new Random();
                if (synonyms != null) {
                    System.out.print(synonyms[r.nextInt(synonyms.length)] + " ");
                } if (Synonyms1 !=null){
                    System.out.print(Synonyms1[r.nextInt(Synonyms1.length)] + " ");
                } else {
                    System.out.print("не существут в списке");
                }
            }
            System.out.println();
        }
    }
}