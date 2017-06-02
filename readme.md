Dans la classe Bulletin de salaire dans entite,
On change private Integer primeExceptionnelle; en private BigDecimal primeExceptionnelle;


********************Cours JUnit pour les test unitaire avec et sans conection à unebase de donnée*********************************************
http://rpouiller.developpez.com/tutoriels/spring/tutoriel-tests-junit4-spring/


******************************************remarque sur les constante***********************************
Static c'est une seul entré en mémoire
final j empéche une re affectation à la varible

une combianaison des deux donne une constante
private static final JE_SUIS_UNE_CONSTANTE

On pourrais avoir différent type de constante (primitif ou complexe)
******************************************************************************************************



******************************Dans la configuration maven des dependncy***************************************************
3.4.1. Scope de dépendance
L'Exemple 3.3, « Dépendances d'un projet » nous a permis d'introduire brièvement trois des cinq scopes de dépendance : compile, test et provided. Le scope contrôle dans quel classpath vont se retrouver les dépendances et quelles seront celles qui seront intégrées à l'application. Regardons ces scopes plus en détail :

compile
compile est le scope par défaut ; toutes les dépendances sont dans ce scope compile si aucun scope n'est précisé. Les dépendances du scope compile se retrouvent dans tous les classpaths et sont packagées avec l'application.

provided
Les dépendances du scope provided sont utilisées lorsqu'elles doivent être fournies par le JDK ou un conteneur. Par exemple, si vous développez une application web, vous aurez besoin de l'API Servlet dans votre classpath pour pouvoir compiler une servlet, mais vous ne voudrez pas inclure l'API Servlet dans votre fichier WAR ; le JAR de l'API Servlet est fourni par votre serveur d'applications ou par votre conteneur de servlet. Les dépendances du scope provided font partie du classpath de compilation (mais pas de celui d'exécution). Elles ne sont pas transitives et ne seront pas packagées avec l'application.

runtime
Les dépendances du scope runtime sont des dépendances nécessaires à l'exécution de l'application et des tests, mais qui sont inutiles à la compilation. Par exemple, vous pouvez avoir besoin d'un JAR pour l'API JDBC à la compilation et uniquement de l'implémentation du driver JDBC à l'exécution.

test
Les dépendances du scope test sont des dépendances qui ne sont pas nécessaires à l'application durant son fonctionnement normal, elles ne servent que durant les phases de compilation et d'exécution des tests. Nous avons déjà parlé du scope test dans la ???.

system
Le scope system est assez proche du scope provided sauf que vous devez fournir un chemin explicite vers le JAR sur le système de fichiers local. Il permet la compilation utilisant des objets natifs faisant partie des bibliothèques système. On suppose que cet artefact est toujours présent et donc il ne sera pas cherché dans un dépôt. Si vous utilisez le scope system, vous devez automatiquement lui adjoindre une balise systemPath. Il est important de noter que l'utilisation de ce scope n'est pas recommandée (vous devriez toujours essayer de référencer des dépendances qui se trouvent dans un dépôt Maven public ou privé).

*******************************************************************

********************************************REMARQUE CONCERNANT  LE BOOTSTRAP*************************************
Si On utilise la methode de mettre le fichier bootstrap-3.3.7-dist dans le folder de l'appli web.

******************************* Faire en haut dans le .html   link rel="stylesheet"*********************************
	href="bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet"
	href="bootstrap-3.3.7-dist/js/bootstrap.js">
	
	*******si c'est dans un jsp*********************
	
	<link rel="stylesheet"
    href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
<link rel="stylesheet"
    href="<c:url value='/bootstrap-3.3.7-dist/js/bootstrap.js'></c:url>">
	