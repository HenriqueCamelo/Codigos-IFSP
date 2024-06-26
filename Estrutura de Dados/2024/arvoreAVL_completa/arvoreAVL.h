typedef struct NO *arvAVL;

arvAVL *cria_arvAVL();

void liberar_arvAVL(arvAVL *raiz);

int vazia_arvAVL(arvAVL *raiz);

int altura_arvAVL(arvAVL *raiz);

int totalNo_arvAVL(arvAVL *raiz);

void preOrdem_arvAVL(arvAVL *raiz);

void emOrdem_arvAVL(arvAVL *raiz);

void posOrdem_arvAVL(arvAVL *raiz);

int consulta_arvAVL(arvAVL *raiz, int valor);

int insere_avrAVL(arvAVL *raiz, int valor);

int remove_arvAVL(arvAVL *raiz, int valor);



