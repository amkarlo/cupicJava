package hr.fer.zemris.java.cstr;

import java.util.Arrays;

/**
 * Created by akarlovic on 2.2.2017..
 */
public class CString {
    private final char[] array;
    private final int offset;
    private final int length;

    CString(char[] data, int offset, int length){
        this.array =  new char[length];
        this.offset = offset;
        this.length = length;
        System.arraycopy(data, offset, array, 0, length);
    }

    CString(char[] data){
        this(data, 0, data.length);
    }

    CString(CString original){
        if (original.length == original.array.length){
            this.array = original.array;
            this.offset = original.offset;
            this.length = original.length;
        }
        else{
            this.length = original.length;
            this.offset = 0;
            this.array = new char[length];
            System.arraycopy(this.array, 0, original.array, offset, length);
        }
    }

    public static CString fromString(String s){
        return new CString(s.toCharArray(), 0, s.length());
    }

    public int length(){
        return length;
    }

    public char charAt(int index){
        return array[index];
    }

    public char[] toCharArray(){
        char[] newCharArray = new char[length];
        System.arraycopy(array, offset, newCharArray, 0, length);
        return newCharArray;
    }

    public String toString(){
        String newString = new String(Arrays.copyOfRange(array, offset, offset+length));
        return newString;
    }

    public int indexOf(char c){
        for (int i = 0; i < length - offset; ++i){
            if (array[offset + i] == c){
                return i;
            }
        }
        return -1;
    }

    public boolean startsWith(CString s){
        for (int i = 0; i < s.length; ++i){
            if (array[offset + i] != s.charAt(i))
                return false;
        }
        return true;
    }

    public boolean endsWith(CString s){
        int border = length - s.length();
        if (border < offset)
            return false;

        for (int i = border; i < length; ++i){
            if (array[i] != s.charAt(i-border))
                return false;
        }
        return true;
    }

    public boolean contains(CString s){
        int len = s.length();

        for (int i = 0; i < length; ++i){
            if (i + len <= length)
                if (this.substring(i, i+len).startsWith(s))
                    return true;
        }
        return false;
    }

    public CString substring(int startIndex, int endIndex){
        if (endIndex <= startIndex)
            throw new IllegalArgumentException("Indexes out of range");
        return new CString(array, startIndex, endIndex - startIndex);
    }

    public CString left(int n){
        if (n < 0 || n > length)
            throw new IllegalArgumentException("Length out of range");

        return new CString(array, 0, n + 1);
    }

    public CString right(int n){
        if (n < 0 || n > length)
            throw new IllegalArgumentException("Length out of range");

        return new CString(array, length - n, length);
    }

    public CString add(CString s){
        int newLength = length + s.length();
        char[] newArray = new char[newLength];
        System.arraycopy(array, offset, newArray, 0, length);

        for(int i=length; i < newLength; ++i){
            newArray[i] = s.charAt(i-length);
        }
        return new CString(newArray);
    }

    public CString replaceAll(char oldChar, char newChar){
        char[] newArray = new char[length];

        for (int i = offset; i < (offset + length); ++i){
            if (array[i] == oldChar)
                newArray[i] = newChar;
            else
                newArray[i] = array[i];
        }
        return new CString(newArray);
    }

    private void replace(char[] array, int start, CString string){
        for (int j = 0; j < string.length(); ++ j){
            array[start + j] = string.charAt(j);
        }
    }

    public CString replaceAll(CString oldStr, CString newStr){
        if (this.contains(oldStr)){
            int newStrLen = newStr.length();
            char[] newArray = new char[length + (length/oldStr.length())*newStrLen];
            int j = 0;
            for (int i = offset; i < offset+length; ++i){
                if (i + oldStr.length() <= offset+length) {
                    CString subString = this.substring(i, i + oldStr.length());
                    if (subString.contains(oldStr)) {
                        i = i + oldStr.length() - 1;
                        replace(newArray, j, newStr);
                        j += newStrLen;
                    } else {
                        newArray[j] = array[i];
                        ++j;
                    }
                }
            }
            return new CString(newArray);
        }
        return this;
    }
}
