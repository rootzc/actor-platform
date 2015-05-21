package im.actor.model.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.model.droidkit.bser.Bser;
import im.actor.model.droidkit.bser.BserParser;
import im.actor.model.droidkit.bser.BserObject;
import im.actor.model.droidkit.bser.BserValues;
import im.actor.model.droidkit.bser.BserWriter;
import im.actor.model.droidkit.bser.DataInput;
import im.actor.model.droidkit.bser.DataOutput;
import im.actor.model.droidkit.bser.util.SparseArray;
import static im.actor.model.droidkit.bser.Utils.*;
import java.io.IOException;
import im.actor.model.network.parser.*;
import java.util.List;
import java.util.ArrayList;
import im.actor.model.api.*;

public class ResponseImportContacts extends Response {

    public static final int HEADER = 0x8;
    public static ResponseImportContacts fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseImportContacts(), data);
    }

    private List<User> users;
    private int seq;
    private byte[] state;

    public ResponseImportContacts(List<User> users, int seq, byte[] state) {
        this.users = users;
        this.seq = seq;
        this.state = state;
    }

    public ResponseImportContacts() {

    }

    public List<User> getUsers() {
        return this.users;
    }

    public int getSeq() {
        return this.seq;
    }

    public byte[] getState() {
        return this.state;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        List<User> _users = new ArrayList<User>();
        for (int i = 0; i < values.getRepeatedCount(1); i ++) {
            _users.add(new User());
        }
        this.users = values.getRepeatedObj(1, _users);
        this.seq = values.getInt(2);
        this.state = values.getBytes(3);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeRepeatedObj(1, this.users);
        writer.writeInt(2, this.seq);
        if (this.state == null) {
            throw new IOException();
        }
        writer.writeBytes(3, this.state);
    }

    @Override
    public String toString() {
        String res = "tuple ImportContacts{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
