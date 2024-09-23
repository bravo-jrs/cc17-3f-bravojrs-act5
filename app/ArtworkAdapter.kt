class ArtworkAdapter(private val artworks: List<Artwork>) : RecyclerView.Adapter<ArtworkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.artwork_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artwork = artworks[position]
        holder.imageView.setImageResource(artwork.image)
        holder.titleTextView.text = artwork.title
        holder.authorTextView.text = artwork.author
    }

    override fun getItemCount(): Int {
        return artworks.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.artworks)
        val titleTextView: TextView = itemView.findViewById(R.id.art_title)
        val authorTextView: TextView = itemView.findViewById(R.id.art_author)
    }
}