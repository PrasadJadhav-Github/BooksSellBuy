import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookssellbuy.databinding.ItemViewBookBinding // Adjust according to your actual binding class path

class BookAdapter(private val bookList: List<BookInfo>, private val context: Context) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    // ViewHolder using View Binding
    class BookViewHolder(private val binding: ItemViewBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: BookInfo) {
            Glide.with(binding.root)
                .load(book.imageUrl)
                .into(binding.itemViewBookImageview)

            binding.itemViewBookTextviewBookName.text = book.bookName
            binding.itemViewBookTextviewBookprice.text = book.bookPrice
            binding.itemViewBookMobileNumber.text = book.mobileNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemViewBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}
