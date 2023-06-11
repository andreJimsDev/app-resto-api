-- CreateTable
CREATE TABLE "Categorie" (
    "id" SERIAL NOT NULL,
    "nom" TEXT NOT NULL,
    "tvaSurPlace" INTEGER NOT NULL,
    "tvaEmporte" INTEGER NOT NULL,
    "imprimanteTicket" BOOLEAN NOT NULL,
    "imprimanteCuisine1" BOOLEAN NOT NULL,
    "imprimanteCuisine2" BOOLEAN NOT NULL,
    "imprimanteCuisine3" BOOLEAN NOT NULL,
    "imprimanteCuisine4" BOOLEAN NOT NULL,
    "visibleCarte1" BOOLEAN NOT NULL,
    "visibleCarte2" BOOLEAN NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3),

    CONSTRAINT "Categorie_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "SousCategorie" (
    "id" TEXT NOT NULL,
    "nom" TEXT NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3),
    "categorieId" INTEGER NOT NULL,

    CONSTRAINT "SousCategorie_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Produit" (
    "id" SERIAL NOT NULL,
    "designation" TEXT NOT NULL,
    "vignette" TEXT,
    "prixAchatHT" INTEGER,
    "prixVenteTC" INTEGER NOT NULL,
    "prixEmporteTC" INTEGER NOT NULL,
    "refArticleFournisseur" TEXT,
    "qteStock" INTEGER,
    "qteMin" INTEGER,
    "cuisson" BOOLEAN,
    "accompagnement" BOOLEAN,
    "gererStock" BOOLEAN,
    "accompagnements" INTEGER[],
    "compositionMenus" INTEGER[],
    "InfosAllergenes" TEXT[],
    "Ingredients" TEXT[],
    "categorieId" INTEGER NOT NULL,

    CONSTRAINT "Produit_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "Categorie_nom_key" ON "Categorie"("nom");

-- CreateIndex
CREATE UNIQUE INDEX "SousCategorie_nom_key" ON "SousCategorie"("nom");

-- CreateIndex
CREATE UNIQUE INDEX "Produit_designation_key" ON "Produit"("designation");

-- AddForeignKey
ALTER TABLE "SousCategorie" ADD CONSTRAINT "SousCategorie_categorieId_fkey" FOREIGN KEY ("categorieId") REFERENCES "Categorie"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Produit" ADD CONSTRAINT "Produit_categorieId_fkey" FOREIGN KEY ("categorieId") REFERENCES "Categorie"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
