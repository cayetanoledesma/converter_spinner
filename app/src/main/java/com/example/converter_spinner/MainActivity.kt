package com.example.converter_spinner


import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.converter_spinner.R.*


class MainActivity: AppCompatActivity() {
    private var op: Int = 0
    private var pos1: Int = 0
    private var pos2: Int = 0
    private var arrayAdapter: ArrayAdapter<String>? = null
    var lengthArray = arrayOf("metros", "Centimetros", "Pulgadas", "Pies")
    var currencyArray = arrayOf("Rupia", "Dolar", "Euro")
    var temperatureArray = arrayOf("Celcius", "Fahrenheit")


    private var spinner1: Spinner? = null
    private var spinner2: Spinner? = null
    private var textinput: EditText? = null
    private var textoutput: TextView? = null

    private var button: Button? = null
    fun length_convert(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        Toast.makeText(this, "length Converter", Toast.LENGTH_SHORT).show()
        intent.putExtra("option", 1)
        startActivity(intent)

    }

    fun currency_convert(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        Toast.makeText(this, "Currency Converter", Toast.LENGTH_SHORT).show()
        intent.putExtra("option", 2)
        startActivity(intent)

    }

    fun temperature_convert(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        Toast.makeText(this, "Temperature Converter", Toast.LENGTH_SHORT).show()
        intent.putExtra("option", 3)
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)



        spinner1 = findViewById(id.spinner1)
        spinner2 = findViewById(id.spinner2)

        textinput = findViewById(id.textinput)
        textoutput = findViewById(id.textoutput)

        op = intent.getIntExtra("option", -1)

        when (op) {
            1 -> {
                arrayAdapter = ArrayAdapter(
                    this,
                    R.layout.simple_spinner_dropdown_item,
                    lengthArray
                )
                spinner1?.adapter = arrayAdapter
                spinner2?.adapter = arrayAdapter

                spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        p0: AdapterView<*>?,
                        p1: View?,
                        p2: Int,
                        p3: Long
                    ) {
                        pos1 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(
                            this@MainActivity,
                            "Nothing Selected",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        p0: AdapterView<*>?,
                        p1: View?,
                        p2: Int,
                        p3: Long
                    ) {
                        pos2 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(
                            this@MainActivity,
                            "Nothing Selected",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            2 -> {
                arrayAdapter = ArrayAdapter(
                    this,
                    R.layout.simple_spinner_dropdown_item,
                    currencyArray
                )
                spinner1?.adapter = arrayAdapter
                spinner2?.adapter = arrayAdapter

                spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        p0: AdapterView<*>?,
                        p1: View?,
                        p2: Int,
                        p3: Long
                    ) {
                        pos1 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(
                            this@MainActivity,
                            "Nothing Selected",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        p0: AdapterView<*>?,
                        p1: View?,
                        p2: Int,
                        p3: Long
                    ) {
                        pos2 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(
                            this@MainActivity,
                            "Nothing Selected",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            3 -> {
                arrayAdapter = ArrayAdapter(
                    this,
                    R.layout.simple_spinner_dropdown_item,
                    temperatureArray
                )
                spinner1?.adapter = arrayAdapter
                spinner2?.adapter = arrayAdapter

                spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        p0: AdapterView<*>?,
                        p1: View?,
                        p2: Int,
                        p3: Long
                    ) {
                        pos1 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(
                            this@MainActivity,
                            "Nothing Selected",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        p0: AdapterView<*>?,
                        p1: View?,
                        p2: Int,
                        p3: Long
                    ) {
                        pos2 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(
                            this@MainActivity,
                            "Nothing Selected",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

        }
        button = findViewById(id.button)
        val onClickListener = button?.setOnClickListener {
            Toast.makeText(this, "Converted", Toast.LENGTH_LONG).show()
            val text1 = textinput?.text.toString().toDouble()

            if (op == 1) {
                if (pos1 == 0) {
                    if (pos2 == 0) {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 1) {
                        textoutput?.text = (text1 * 100).toString()
                    } else if (pos2 == 2) {
                        textoutput?.text = (text1 * 39.3701).toString()
                    } else if (pos2 == 3) {
                        textoutput?.text = (text1 * 3.28084).toString()
                    }
                } else if (pos1 == 1) {
                    if (pos2 == 0) {
                        textoutput?.text = (text1 / 100).toString()
                    } else if (pos2 == 1) {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 2) {
                        textoutput?.text = (text1 * 0.303701).toString()
                    } else if (pos2 == 3) {
                        textoutput?.text = (text1 * 0.0328084).toString()
                    }
                } else if (pos1 == 2) {
                    if (pos2 == 0) {
                        textoutput?.text = (text1 * 0.0254).toString()
                    } else if (pos2 == 1) {
                        textoutput?.text = (text1 * 2.54).toString()
                    } else if (pos2 == 2) {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 3) {
                        textoutput?.text = (text1 * 0.0833333).toString()
                    }
                } else if (pos1 == 3) {
                    if (pos2 == 0) {
                        textoutput?.text = (text1 * 0.3048).toString()
                    } else if (pos2 == 1) {
                        textoutput?.text = (text1 * 30.48).toString()
                    } else if (pos2 == 2) {
                        textoutput?.text = (text1 * 12).toString()
                    } else if (pos2 == 3) {
                        textoutput?.text = (text1).toString()
                    }
                }
            } else if (op == 2) {
                if (pos1 == 0) {
                    if (pos2 == 0) {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 1) {
                        textoutput?.text = (text1 / 70).toString()
                    } else if (pos2 == 2) {
                        textoutput?.text = (text1 / 85).toString()
                    }
                } else if (pos1 == 1) {
                    if (pos2 == 0) {
                        textoutput?.text = (text1 * 75.70).toString()
                    } else if (pos2 == 1) {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 2) {
                        textoutput?.text = (text1 * 0.90).toString()
                    }

                } else if (pos1 == 2) {
                    if (pos2 == 0) {
                        textoutput?.text = (text1 * 84.57).toString()
                    } else if (pos2 == 1) {
                        textoutput?.text = (text1 * 1.12).toString()
                    } else if (pos2 == 2) {
                        textoutput?.text = (text1).toString()
                    }

                } else if (op == 3) {
                    if (pos1 == 0) {
                        if (pos2 == 0) {
                            textoutput?.text = (text1).toString()
                        } else if (pos2 == 1) {
                            textoutput?.text = ((1.8) * text1 + 32).toString()
                        }
                    } else if (pos1 == 1) {
                        if (pos2 == 0) {
                            textoutput?.text = (((text1 - 32) * 5) / 9).toString()
                        } else if (pos2 == 1) {
                            textoutput?.text = (text1).toString()
                        }
                    }
                }
            }
        }
    }
}



