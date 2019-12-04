/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mari Bianchini
 */
public class TCPServerSocket {
    public static void main(String[] args) {
  ServerSocket serverSocket = null;
        Socket listenSocket = null;
        try {
            serverSocket = new ServerSocket(6789);
            System.out.println("Aguardando conexao...");
            listenSocket = serverSocket.accept();
            System.out.println("Cliente conectado!!");
            DataInputStream dis = new DataInputStream(
                    listenSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(
                    listenSocket.getOutputStream());
            
            String nome = dis.readUTF();
            System.out.println("Recebido "+nome);
            String hello = "Hello "+nome;
            dos.writeUTF(hello);            
            System.out.println("Enviado "+hello);
            
        } catch (IOException ex) {
            Logger.getLogger(TCPServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(listenSocket != null){
                try {
                    listenSocket.close();
                    serverSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(TCPServerSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } 
    }    