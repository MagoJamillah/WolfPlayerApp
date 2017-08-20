package magojamillah.wolfplayer;


import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistFragment extends Fragment {

    ArrayList<Artist> artistList;

    public ArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_artist, container, false);
        artistList = new ArrayList<>();

        getSongList();

        ArtistAdapter artistAdt = new ArtistAdapter(ArtistFragment.this.getActivity(), artistList);
        ListView artistView = (ListView)view.findViewById(R.id.artistlist);

        artistView.setAdapter(artistAdt);



        return view;


    }


    public void getSongList(){
        //query external audio
        ContentResolver musicResolver = getActivity().getApplicationContext().getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);
        //iterate over results if valid
        if(musicCursor!=null && musicCursor.moveToFirst()){
            //get columns


            int artistColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ARTIST);
            //add songs to list
            do {

                String thisArtist = musicCursor.getString(artistColumn);
                artistList.add(new Artist(thisArtist));
            }
            while (musicCursor.moveToNext());
        }
    }

}
