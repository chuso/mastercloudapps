package mastermindWeek3.mastermind.distributed.dispatchers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPIP extends mastermindWeek3.santaTecla.utils.TCPIP {

    private static final int PORT = 2020;

    public TCPIP(Socket socket) {
        super(socket);
    }

    public TCPIP(ServerSocket serverSocket, Socket socket) {
        super(serverSocket, socket);
    }

    public static TCPIP createClientSocket() {
        try {
            Socket socket = new Socket("localhost", TCPIP.PORT);
            System.out.println("Cliente> Establecida conexion");
            return new TCPIP(socket);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TCPIP createServerSocket() {
        try {
            ServerSocket serverSocket = new ServerSocket(TCPIP.PORT);
            System.out.println("Servidor> Esperando conexion...");
            Socket socket = serverSocket.accept();
            System.out.println("Servidor> Recibida conexion de " + socket.getInetAddress().getHostAddress() + ":"
                    + socket.getPort());
            return new TCPIP(serverSocket, socket);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // TODO: implement sender and receivers methods

}
