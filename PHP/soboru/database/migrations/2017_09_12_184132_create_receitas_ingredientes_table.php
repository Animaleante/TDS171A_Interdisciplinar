<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateReceitasIngredientesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('receitas_ingredientes', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('receita_id');
            $table->integer('ingrediente_id');
            $table->integer('medida_id');
            $table->string('subsessao')->nullable();
            $table->decimal('qty', 5, 2);
            $table->timestamps();
            $table->softDeletes();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('receitas_ingredientes');
    }
}
