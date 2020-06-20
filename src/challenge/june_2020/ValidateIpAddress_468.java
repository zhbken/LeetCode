package challenge.june_2020;


public class ValidateIpAddress_468 {

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }

        if (IP.contains(".")) {
            String[] split = IP.split("\\.");
            if (split.length == 4 && !(IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.')) {
                for (String str: split) {
                    try {
                        int i = Integer.parseInt(str);
                        if (!(i >= 0 && i <=255) || (str.length() > 1 && (str.charAt(0) == '-' || str.charAt(0) == '+' ||  str.charAt(0) == '0'))) {
                            return "Neither";
                        }
                    } catch (NumberFormatException e){
                        return "Neither";
                    }
                }
                return "IPv4";
            }
        } else if (IP.contains(":")) {
            String[] split = IP.split("\\:");
            if (split.length == 8 && !(IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':')) {

                for (String hex: split) {
                    try {
                        if (hex.length() == 0) return "Neither";
                        int i = Integer.parseInt(hex, 16);
                        if ((hex.length() > 4)  || hex.charAt(0) == '-' || hex.charAt(0) == '+') {
                            return "Neither";
                        }
                    } catch (NumberFormatException e){
                        return "Neither";
                    }
                }
                return "IPv6";
            }
        }

        return "Neither";
    }
}
