import com.example

def call(String imageName){
    return new Docker(this).buildDockerImage(imageName)
}