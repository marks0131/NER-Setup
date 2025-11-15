fun main() {
    println("--- インストーラーを開始します ---")

    // OS固有の機能を提供する World インスタンスを作成
    val os = World()

    // 1. Gitのインストール
    println("[1/7] Gitをインストールしています...")
    val gitResult = os.installGit()
    if (gitResult.isFailure) {
        println("Gitのインストールに失敗: ${gitResult.error}")
        return
    }

    // 2. リポジトリのclone
    println("[2/7] リポジトリをcloneしています...")
    val repoUrl = "https://github.com/Stone5656/NER-can-use-NPU-Test.git"
    os.runShellCommand("git", listOf("clone", repoUrl))

    val repoDir = "NER-can-use-NPU-Test"

    // 3. Python & pip のインストール
    println("[3/7] Python & pip をインストールしています...")
    val pyResult = os.installPython()
    if (pyResult.isFailure) {
        println("Pythonのインストールに失敗: ${pyResult.error}")
        return
    }

}