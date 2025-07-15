package adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.example.moduloivv2.R
import models.Country

class CountryAdapter(private val countriesList: List<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val cuntryView = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_card_view, parent, false)
        return CountryViewHolder(cuntryView)
    }

    private var onItemClickListener: ((Country) -> Unit)? = null

    fun setOnItemClickListener(listener: (Country) -> Unit){
        onItemClickListener = listener
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countriesList[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int = countriesList.size

    inner class CountryViewHolder(contryView: View) : RecyclerView.ViewHolder (contryView){
        private val txtCountryName : TextView = contryView.findViewById(R.id.txtCountryName)
        private val txtOfficialName : TextView = contryView.findViewById(R.id.txtOfficialName)
        private val imgFlag : ImageView = contryView.findViewById(R.id.imgFlag)

        fun bind(country: Country){
            txtCountryName.text = country.name
            txtOfficialName.text = country.officialName
            Glide.with(itemView.context)
                .load(country.imageURL)
                .into(imgFlag)

            itemView.setOnClickListener {
                onItemClickListener?.invoke(country)
            }
        }
    }
}