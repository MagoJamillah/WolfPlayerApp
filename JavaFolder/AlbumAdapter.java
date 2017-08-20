package magojamillah.wolfplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MagoJamillah on 07/08/2017.
 */
public class AlbumAdapter extends BaseAdapter {

    private ArrayList<Album> albums;
    private LayoutInflater albumInf;

    public AlbumAdapter(Context c, ArrayList<Album> theAlbums){
        albums=theAlbums;
        albumInf=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return albums.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout albumLay = (LinearLayout)albumInf.inflate
                (R.layout.album, parent, false);
        //get title and artist views
        TextView artistView = (TextView)albumLay.findViewById(R.id.song_album);
        //get song using position
        Album currArtist = albums.get(position);
        //get title and artist strings


        artistView.setText("   " + currArtist.getAlbum() + "\n");

        //set position as tag
        albumLay.setTag(position);
        return albumLay;
    }
}
