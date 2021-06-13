package com.example.contrasenyes_segures.cryptography;

import android.util.Base64;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AESCryptTest extends TestCase {

    public void testEncryptDecrypt_Empty() throws Exception {
        String data = "";

        String enc = AESCrypt.encrypt(data);
        assertNotEquals(data, enc);

        String dec = AESCrypt.decrypt(enc);
        assertEquals(data, dec);
    }

    public void testEncryptDecrypt_Normal() throws Exception {
        String data = "cafadgwed";

        String enc = AESCrypt.encrypt(data);
        assertNotEquals(data, enc);

        String dec = AESCrypt.decrypt(enc);
        assertEquals(data, dec);
    }

    public void testEncryptDecrypt_BigString() throws Exception {
        String data = "kasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsdkasjndafuwejsnfsdlkfvkjdshnfvjdshgfdsjfkdskfdjskvnjsd fsdjfkbsdfjsdkhfjsd";

        String enc = AESCrypt.encrypt(data);
        assertNotEquals(data, enc);

        String dec = AESCrypt.decrypt(enc);
        assertEquals(data, dec);
    }

    public void testEncryptDecrypt_SpecialChars() throws Exception {
        String data = ",.-~|@#€~€¬=)/()%/%&$!\"sadsafwe";

        String enc = AESCrypt.encrypt(data);
        assertNotEquals(data, enc);

        String dec = AESCrypt.decrypt(enc);
        assertEquals(data, dec);
    }

    public void testEncryptDecrypt_AllASCIChars() throws Exception {
        String data = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~¡¢£¤¥¦§¨©ª«¬\u00AD®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĂăĄąĆćČčĎďĐđĘęĚěĹĺĽľŁłŃńŇňŐőŒœŔŕŘřŚśŞşŠšŢţŤťŮůŰűŸŹźŻżŽžƒˆˇ˘˙˛˜˝–—‘’‚“”„†‡•…‰‹›€™";

        String enc = AESCrypt.encrypt(data);
        assertNotEquals(data, enc);

        String dec = AESCrypt.decrypt(enc);
        assertEquals(data, dec);
    }

    public void testEncryptDecrypt_NonASCIChars() throws Exception {
        // Hindi, Chino, hebreo, Tamil
        String data = "भारत网络קוםஇந்தியாஇந்தியா";

        String enc = AESCrypt.encrypt(data);
        assertNotEquals(data, enc);

        String dec = AESCrypt.decrypt(enc);
        assertEquals(data, dec);
    }
}