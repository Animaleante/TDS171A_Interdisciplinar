<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUtensiliosTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('utensilios', function (Blueprint $table) {
            $table->increments('id');
            $table->string('nome_utensilio')->unique();
            $table->timestamps();
            $table->softDeletes();
        });

        Schema::create('receita_utensilio', function (Blueprint $table) {
            $table->integer('receita_id');
            $table->integer('utensilio_id');
            $table->primary(['receita_id', 'utensilio_id']);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('utensilios');
        Schema::dropIfExists('receita_utensilio');
    }
}
