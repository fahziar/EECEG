/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eeceg;

/**
 *
 * @author Fahziar
 */
public class HexConvert {
    private final static String[] hexSymbols = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public final static int BITS_PER_HEX_DIGIT = 4;

    public static String toHexFromByte(final byte b)
    {
    	byte leftSymbol = (byte)((b >>> BITS_PER_HEX_DIGIT) & 0x0f);
    	byte rightSymbol = (byte)(b & 0x0f);

    	return (hexSymbols[leftSymbol] + hexSymbols[rightSymbol]);
    }

    public static String toHexFromBytes(final byte[] bytes)
    {
    	if(bytes == null || bytes.length == 0)
    	{
    		return ("");
    	}

    	// there are 2 hex digits per byte
    	StringBuilder hexBuffer = new StringBuilder(bytes.length * 2);

    	// for each byte, convert it to hex and append it to the buffer
    	for(int i = 0; i < bytes.length; i++)
    	{
    		hexBuffer.append(toHexFromByte(bytes[i]));
                
                if ((i + 1) % 16 == 0)
                {
                    hexBuffer.append("\n");
                } else {
                    hexBuffer.append(" ");
                }
    	}

    	return (hexBuffer.toString());
    }
}
