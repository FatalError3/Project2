package sample;
@Named
@RequestScoped
public class OpenFileController {
	@Inject
	private IOpenFile openFile;

	public byte[] doOpenFile (File file){
		return openFile.openFile(file);
	}
}
