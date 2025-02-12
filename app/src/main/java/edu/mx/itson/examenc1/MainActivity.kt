package edu.mx.itson.examenc1

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var cantidad = 0
    var subtotal = 0.0
    private lateinit var txtSubtotal: TextView
    private lateinit var txtSubtotalNumero: TextView
    private lateinit var txtIVA: TextView
    private lateinit var txtIVANumero: TextView
    private lateinit var txtTotal: TextView
    private lateinit var txtTotalNumero: TextView
//    val productos:List<String> = ArrayList()
//    val cantidades:List<String> = ArrayList()
//    val precios:List<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtSubtotal = findViewById(R.id.txtSubtotal)
        txtSubtotalNumero = findViewById(R.id.txtSubtotalNumero)
        txtIVA = findViewById(R.id.txtIVA)
        txtIVANumero = findViewById(R.id.txtIVANumero)
        txtTotal = findViewById(R.id.txtTotal)
        txtTotalNumero = findViewById(R.id.txtTotalNumero)

        val edtCantidad = findViewById<EditText>(R.id.edtCantidad)
        val edtNombre = findViewById<EditText>(R.id.edtNombre)
        val edtPrecio = findViewById<EditText>(R.id.edtPrecio)

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        val txtCantidad = findViewById<TextView>(R.id.txtCantidad)
        val txtProductos = findViewById<TextView>(R.id.txtProductos)
        val txtPrecio = findViewById<TextView>(R.id.txtPrecio)

        val txtCantidad1 = findViewById<TextView>(R.id.txtCantidad1)
        val txtCantidad2 = findViewById<TextView>(R.id.txtCantidad2)
        val txtCantidad3 = findViewById<TextView>(R.id.txtCantidad3)

        val txtProductos1 = findViewById<TextView>(R.id.txtProductos1)
        val txtProductos2 = findViewById<TextView>(R.id.txtProductos2)
        val txtProductos3 = findViewById<TextView>(R.id.txtProductos3)

        val txtPrecio1 = findViewById<TextView>(R.id.txtPrecio1)
        val txtPrecio2 = findViewById<TextView>(R.id.txtPrecio2)
        val txtPrecio3 = findViewById<TextView>(R.id.txtPrecio3)

        btnAgregar.setOnClickListener {
            val prod = edtNombre.text.toString()
            val cant = edtCantidad.text.toString().toInt()
            val prec = edtPrecio.text.toString().toFloat()

            if(cantidad == 0) {
                cantidad++
                txtCantidad1.setText(cant.toString())
                txtPrecio1.setText((prec * cant).toString())
                txtProductos1.setText(prod)
            } else if(cantidad == 1) {
                cantidad++
                txtCantidad2.setText(cant.toString())
                txtPrecio2.setText((prec * cant).toString())
                txtProductos2.setText(prod)
            } else if(cantidad == 2) {
                cantidad++
                txtCantidad3.setText(cant.toString())
                txtPrecio3.setText((prec * cant).toString())
                txtProductos3.setText(prod)
            } else {
                showAlert("Ya has ingresado todos los productos")
            }

            subtotal+=prec * cant
            calcularPrecio()
        }

    }

    fun calcularPrecio() {
        txtSubtotalNumero.setText(subtotal.toString())
        txtIVANumero.setText((subtotal * 0.16).toString())
        txtTotalNumero.setText((subtotal + (subtotal * 0.16)).toString())
    }

    fun showAlert(message: String) {
        AlertDialog.Builder(this)
            .setTitle("Error...")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}