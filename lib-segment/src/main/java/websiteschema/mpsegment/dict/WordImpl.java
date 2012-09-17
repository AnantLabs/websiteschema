package websiteschema.mpsegment.dict;

import websiteschema.mpsegment.util.BufReader;
import java.io.*;
import websiteschema.mpsegment.conf.Configure;

public class WordImpl
        implements Serializable, Comparable, IWord {

    public WordImpl(String wordName) {
        log2Freq = 0;
        this.wordName = wordName;
        domainType = 0;
    }

    public WordImpl(String wordName, int i) {
        log2Freq = 0;
        this.wordName = wordName;
        domainType = i;
    }

    public WordImpl(BufReader bufreader)
            throws IOException {
        log2Freq = 0;
        load(bufreader);
    }

    @Override
    public void setOccuredCount(String posName, int freq) {
        POSAndFreq.setFreq(indexOfPosDB, wordPOSNumber, POSUtil.getPOSIndex(posName), freq);
    }

    @Override
    public void setOccuredCount(int factor) {
        POSAndFreq.setScaleFreq(indexOfPosDB, wordPOSNumber, factor);
        log2Freq = 0;
        getLog2Freq();
    }

    @Override
    public POSArray getPOSArray() {
        if (null == posArray || posArray.getSize() != wordPOSNumber) {
            return buildPOSArray();
        }
        return posArray;
    }

    private POSArray buildPOSArray() {
        posArray = new POSArray();
        for (int i = 0; i < wordPOSNumber; i++) {
            String name = POSUtil.getPOSString(POSAndFreq.getPOS(indexOfPosDB + i));
            int count = POSAndFreq.getFreq(indexOfPosDB + i);
            POS pos = new POS(name, count);
            posArray.add(pos);
        }
        return posArray;
    }

    @Override
    public int getWordMaxPOS() {
        return POSAndFreq.getMaxOccuriedPOS(indexOfPosDB, wordPOSNumber);
    }

    @Override
    public int getWordPOSTable(int posTable[][]) {
        for (int i = 0; i < wordPOSNumber; i++) {
            if (i < posTable.length) {
                posTable[i][0] = POSAndFreq.getPOS(indexOfPosDB + i);
                posTable[i][1] = POSAndFreq.getFreq(indexOfPosDB + i);
            }
        }
        for (int j = wordPOSNumber; j < posTable.length; j++) {
            posTable[j][0] = 0;
            posTable[j][1] = 0;
        }
        return wordPOSNumber;
    }

    @Override
    public String getWordName() {
        return wordName;
    }

    @Override
    public void setWordName(String s) {
        wordName = s;
    }

    @Override
    public int getWordLength() {
        return wordName.length();
    }

    @Override
    public void setDomainType(int i) {
        domainType = i;
    }

    @Override
    public int getDomainType() {
        return domainType;
    }

    @Override
    public int getLog2Freq() {
        if (log2Freq == 0) {
            log2Freq = (int) (Math.log(getOccuredSum() + 1L) * 100D);
        }
        return log2Freq;
    }

    @Override
    public long getOccuredSum() {
        return (long) POSAndFreq.getFreqSum(indexOfPosDB, wordPOSNumber);
    }

    @Override
    public long getOccuredCount(String s) {
        int i = POSUtil.getPOSIndex(s);
        return (long) POSAndFreq.getPOSFreq(indexOfPosDB, wordPOSNumber, i);
    }

    @Override
    public void incOccuredCount(String s) {
        int i = POSUtil.getPOSIndex(s);
        POSAndFreq.incPOSFreq(indexOfPosDB, wordPOSNumber, i);
    }

    public void setPOSFreq(int i, int j) {
        indexOfPosDB = i;
        wordPOSNumber = j;
    }

    public final void load(RandomAccessFile randomaccessfile)
            throws IOException {
        byte byte0 = randomaccessfile.readByte();
        byte abyte0[] = new byte[byte0];
        randomaccessfile.read(abyte0);
        wordName = new String(abyte0, Configure.getInstance().getFileEncoding());
        domainType = randomaccessfile.readInt();
        domainType /= 100;
        indexOfPosDB = randomaccessfile.readInt();
        wordPOSNumber = randomaccessfile.readInt();
    }

    public String toText() {
        String space = " ";
        StringBuilder sb = new StringBuilder();

        sb.append(wordName).append(space);
        sb.append(domainType).append(space);
        sb.append(indexOfPosDB).append(space);
        sb.append(wordPOSNumber).append(space);
        return sb.toString();
    }

    private void load(BufReader bufreader)
            throws IOException {
        int i = bufreader.readIntByte();
        byte wordNameBytes[] = new byte[i];
        bufreader.read(wordNameBytes);
        wordName = new String(wordNameBytes, Configure.getInstance().getFileEncoding());
        domainType = bufreader.readInt();
        domainType /= 100;
        indexOfPosDB = bufreader.readInt();
        wordPOSNumber = bufreader.readInt();
    }

    @Override
    public void save(RandomAccessFile randomaccessfile)
            throws IOException {
        byte abyte0[] = wordName.getBytes(Configure.getInstance().getFileEncoding());
        randomaccessfile.write((byte) abyte0.length);
        randomaccessfile.write(abyte0);
        domainType *= 100;
        int i = domainType;
        randomaccessfile.writeInt(i);
        randomaccessfile.writeInt(indexOfPosDB);
        randomaccessfile.writeInt(wordPOSNumber);
    }

    @Override
    public int compareTo(Object obj) {
        if (obj != null && (obj instanceof String)) {
            return wordName.compareTo((String) obj);
        }
        if (obj != null && (obj instanceof WordImpl)) {
            return wordName.compareTo(((WordImpl) obj).wordName);
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof WordImpl)) {
            return wordName.equals(((WordImpl) obj).wordName);
        }
        if (obj != null && (obj instanceof String)) {
            return wordName.equals(obj);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((new StringBuilder(String.valueOf(getWordName()))).append("\n").toString());
        stringBuilder.append(getPOSArray().toString());
        return stringBuilder.toString();
    }

    @Override
    public String toWordString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((new StringBuilder(String.valueOf(getWordName()))).append("\\").toString());
        return stringBuilder.toString();
    }

    @Override
    public String toDBFString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPOSArray().toDBFString(getWordName()));
        return stringBuilder.toString();
    }
    private String wordName;
    private int domainType;
    private int log2Freq;
    private int indexOfPosDB;
    private int wordPOSNumber;
    private POSArray posArray;
}
