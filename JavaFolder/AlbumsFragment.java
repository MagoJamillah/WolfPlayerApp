package magojamillah.wolfplayer;


import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumsFragment extends Fragment {

    ArrayList<Album> albumList;



    public AlbumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_albums, container, false);
        albumList = new ArrayList<>();

        getAlbumList();

        AlbumAdapter albumAdt = new AlbumAdapter(AlbumsFragment.this.getActivity(), albumList);
        ListView albumView = (ListView)view.findViewById(R.id.albumlist);

        albumView.setAdapter(albumAdt);



        return view;
    }

    public void getAlbumList(){
        //query external audio
        ContentResolver musicResolver = getActivity().getApplicationContext().getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);
        //iterate over results if valid
        if(musicCursor!=null && musicCursor.moveToFirst()){
            //get columns


            int albumColumn = musicCursor.getColumnIndex
                    (MediaStore.Audio.Media.ALBUM);
            //add songs to list
            do {

                String thisAlbum = musicCursor.getString(albumColumn);
                albumList.add(new Album(thisAlbum));
            }
            while (musicCursor.moveToNext());
        }
    }

}
