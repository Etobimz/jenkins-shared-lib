

def call () {

     echo "Building the application... ${env.BRANCH_NAME}"
                    sh 'mvn package'


}
