public class Encrypter {
    public String encrypt(String e) {
        int encArray[] = new int[4];
        int tempInt;
        String newE = "";

        //copy string to int array...
        for (int i = 0; i < 4; i++) {
            encArray[i] = e.charAt(i);
        }

        //add 7 to each num in array...
        for (int i = 0; i < 4; i++) {
            encArray[i] += 7;
        }

        //swap digits 1 and 3...
        tempInt = encArray[0];
        encArray[0] = encArray[2];
        encArray[2] = tempInt;
        //swap digits 2 and 4...
        tempInt = encArray[1];
        encArray[1] = encArray[3];
        encArray[3] = tempInt;

        //copy int array to string...
        for (int i = 0; i < 4; i++) {
            newE += Integer.toString(encArray[i]);
        }
        return newE;
    }
}
