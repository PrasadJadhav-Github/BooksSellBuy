import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bookssellbuy.databinding.FragmentHomeBinding
import com.google.firebase.database.*

class Home_Fragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var databaseReference: DatabaseReference
    private lateinit var homefragmentrecyclerview:RecyclerView
    private lateinit var bookarraylist:ArrayList<BookInfo>
    private lateinit var homeBookAdapter: BookAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        fetchDataFromFirebase()


        homefragmentrecyclerview = binding.recyclerviewbooks
        homefragmentrecyclerview.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        databaseReference=FirebaseDatabase.getInstance().getReference("BookInfo")
        bookarraylist=ArrayList()
        homeBookAdapter=BookAdapter(bookarraylist,requireContext())
        homefragmentrecyclerview.adapter=homeBookAdapter
        return binding.root
    }

    private fun fetchDataFromFirebase() {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Clear existing list before adding new data
                bookarraylist.clear()

                // Iterate through each snapshot and convert to BookInfo object
                for (dataSnapshot in snapshot.children) {
                    val book = dataSnapshot.getValue(BookInfo::class.java)
                    book?.let {
                        bookarraylist.add(it)
                    }
                }
                // Notify adapter of data change
                homeBookAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle database error
                // For now, let's just log the error message
                error.toException().printStackTrace()
            }
        })
    }
}
