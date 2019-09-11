package com.tarantsoff.telegraph;

import org.telegram.telegraph.ExecutorOptions;
import org.telegram.telegraph.TelegraphContext;
import org.telegram.telegraph.TelegraphContextInitializer;
import org.telegram.telegraph.TelegraphLogger;
import org.telegram.telegraph.api.methods.CreatePage;
import org.telegram.telegraph.api.objects.Node;
import org.telegram.telegraph.api.objects.NodeElement;
import org.telegram.telegraph.api.objects.NodeText;
import org.telegram.telegraph.api.objects.Page;
import org.telegram.telegraph.exceptions.TelegraphException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class CreatePageCommand {

    static {
        TelegraphLogger.setLevel(Level.ALL);
        TelegraphLogger.registerLogger(new ConsoleHandler());

        // Initialize context
        TelegraphContextInitializer.init();
        TelegraphContext.registerInstance(ExecutorOptions.class, new ExecutorOptions());

    }

    public static void main(String[] args) {
        String pageTitle = "Джембе. Индийский барабан ручной работы.";

        List<Node> content = new ArrayList<>();

        String paragraph = "Прекрасный качественный джембе. Сделан из дерева манго. Звучит отлично.\n" +
                "\n" +
                "Диаметр мембраны - 28 сантиметров.\n" +
                "\n" +
                "Был привезен из Индии.\n" +
                "Это не один из тех одноразовых барабанов-сувениров, которые продают доверчивым пакетным туристам на пляже бродячие торговцы.\n" +
                "Этот инструмент - качественный. Долго выбирался в магазине у индийского мастера вместе с нашим специалистом.\n" +
                "То что на мембране на фото выглядит как разводы - это такая структура кожи.\n" +
                "\n" +
                "Куплен в Арамболе.\n" +
                "Пахнет Индией и несёт в себе частичку её духа :)\n" +
                "Покупался для себя, поэтому задачи сэкономить не было.\n" +
                "\n" +
                "Джембе несколько лет простоял на полке, ожидая моего вдохновения, но так и не дождался.\n" +
                "\n" +
                "Теперь пришло время ему найти себе нового владельца, которого он будет радовать своим чистым звуком.\n" +
                "\n" +
                "С мембраной за это время ничего не произошло. По прежнему в идеальном состоянии.\n" +
                "\n" +
                "Внизу на древесине есть маленький скол, на который я никогда не обращал внимания и заметил его только когда делал фото.\n" +
                "На звук он, естественно, не влияет. Можно закрасить.\n" +
                "\n" +
                "Обоснованный торг приветствуется.\n" +
                "\n" +
                "Кстати, погуглите arambol drum circle ;)";

        Node paragraphNode = new NodeText(paragraph);
        content.add(paragraphNode);

        List<String> images = new ArrayList<>();
        images.add("https://apollo-ireland.akamaized.net:443/v1/files/x4xf1h54vfrp1-UA/image;s=1000x700");
        images.add("https://apollo-ireland.akamaized.net:443/v1/files/2srfgfqfk0oe2-UA/image;s=1000x700");
        images.add("https://apollo-ireland.akamaized.net:443/v1/files/uwtk968tc0bw-UA/image;s=1000x700");
        images.add("https://apollo-ireland.akamaized.net:443/v1/files/qqr3qlsm5m7x2-UA/image;s=1000x700");

        for (String imageSource : images) {
            addImageNode(content, imageSource);
        }
        // Create new page
        try {

            Page page = new CreatePage(AccountInfo.ACCESS_TOKEN, pageTitle, content)
                    .setAuthorName(AccountInfo.AUTHOR_NAME)
                    .setReturnContent(false)
                    .execute();
            // stop
            String url = page.getUrl();
            System.out.println("url = " + url);
        } catch (TelegraphException e) {
            TelegraphLogger.severe("MAIN", e);
        }
    }

    private static void addImageNode(List<Node> content, String url) {
        HashMap<String, String> attrs = new HashMap<>();
        attrs.put("src", url);
        Node imageNode = new NodeElement("img", attrs, Collections.emptyList());
        content.add(imageNode);
    }
}
