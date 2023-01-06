package com.markus.spring.conversion;

/**
 * @author: markus
 * @date: 2023/1/6 9:57 PM
 * @Description:
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class PropertyEditorDemo {
    public static void main(String[] args) {
        StringToPropertiesPropertyEditor propertiesPropertyEditor = new StringToPropertiesPropertyEditor();
        String properties = "name = MarkusZhang";
        propertiesPropertyEditor.setAsText(properties);
        System.out.println(propertiesPropertyEditor.getValue());
    }
}
