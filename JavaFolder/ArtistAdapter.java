package magojamillah.wolfplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by MagoJamillah on 04/08/2017.
 */
public class ArtistAdapter extends BaseAdapter {

    private ArrayList<Artist> artists;
    private LayoutInflater artistInf;
    public ArtistAdapter(Context c, ArrayList<Artist> theArtists){
        artists=theArtists;
        artistInf=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {

        return artists.size();
    }

    @Override
    public Object getItem(int arg0) {

        return null;
    }

    @Override
    public long getItemId(int arg0) {

        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //map to song layout
        LinearLayout artistLay = (LinearLayout)artistInf.inflate
                (R.layout.artist, parent, false);
        //get title and artist views
         TextView artistView = (TextView)artistLay.findViewById(R.id.song_artist);
        //get song using position
        Artist currArtist = artists.get(position);
        //get title and artist strings
        artistView.setText("    "+currArtist.getArtist() + "\n");

        //set position as tag
        artistLay.setTag(position);
        return artistLay;

    }
}
